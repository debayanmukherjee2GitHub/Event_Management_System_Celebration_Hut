package bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Base64;
import util.DataConnection;

public class EventPic {
	private int epicid;
	private String epictitle;
	private String epicdescription;
	private InputStream epicimage;
	private String filename;
	
	public boolean add() throws SQLException{
		Connection con=DataConnection.connect();
		
		//Create SQL Query
		String sql="insert into event_pic(epictitle,epicdescription,epicimage,filename) values(?,?,?,?)";
		
		//Create Statement
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, epictitle);
		ps.setString(2, epicdescription);
		ps.setBinaryStream(3,epicimage);
		ps.setString(4, filename);
		
		//Execute Statement
		int xx=ps.executeUpdate();
		
		return xx>0;
	}
	
	protected boolean getAllPhoto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         try {
            Connection conn =  DataConnection.connect();
            PreparedStatement ps = conn.prepareStatement("select epicimage from "
            													+ "event_pic where epicid=?");
            String epicid = request.getParameter("epicid");
            ps.setString(1,epicid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            Blob  b = rs.getBlob("epicimage");            
            response.setContentType("image/jpeg");
            response.setContentLength( (int) b.length());
            response.setContentLength(100);
            InputStream is = b.getBinaryStream();
            OutputStream os = response.getOutputStream();
            byte buf[] = new byte[(int) b.length()];
            is.read(buf);
            os.write(buf);
            os.flush();
            }
        }
        catch(Exception ex) {
             ex.printStackTrace();
        }
		return false;
    }
	
	public ArrayList<EventPic> getAllEventPic() throws SQLException{
		
		Connection con=DataConnection.connect();
		String sql="select * from event_pic";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
		ArrayList<EventPic> eventpic=new ArrayList<>();
		while(rs.next()){
			EventPic event=new EventPic();
			event.epicid=rs.getInt("epicid");
			event.epictitle=rs.getString("epictitle");
			event.epicdescription=rs.getString("epicdescription");
			event.epicimage=rs.getBinaryStream("epicimage");
						
			eventpic.add(event);
		}
		return eventpic;
	}
	
	public String getEventImageAsString() throws IOException{
		byte []buff=new byte[this.epicimage.available()];
		
		this.epicimage.read(buff);
		
		String imgString=Base64.encodeBytes(buff);
		buff=null;
		return imgString;
	}
	
	public EventPic getAllEventPicById(int epicId) throws SQLException{
		System.out.println("Ad ID: "+epicId);
		Connection con=DataConnection.connect();
		String sql="select * from event_pic where epicid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, epicId);
		
		ResultSet rs=ps.executeQuery();
			
		rs.next();
		
		EventPic event=new EventPic();
		
		event.epicid=rs.getInt("epicid");
		event.epictitle=rs.getString("epictitle");
		event.epicdescription=rs.getString("epicdescription");
		event.epicimage=rs.getBinaryStream("epicimage");
		event.filename=rs.getString("filename");
		
		return event; 
	}
	
	public int getEpicid() {
		return epicid;
	}
	public void setEpicid(int epicid) {
		this.epicid = epicid;
	}
	public String getEpictitle() {
		return epictitle;
	}
	public void setEpictitle(String epictitle) {
		this.epictitle = epictitle;
	}
	public String getEpicdescription() {
		return epicdescription;
	}
	public void setEpicdescription(String epicdescription) {
		this.epicdescription = epicdescription;
	}

	public InputStream getEpicimage() {
		return epicimage;
	}

	public void setEpicimage(InputStream epicimage) {
		this.epicimage = epicimage;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
		
}
