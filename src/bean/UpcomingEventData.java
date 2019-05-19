package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.DataConnection;

public class UpcomingEventData {

	private int ueventid;
	private String ueventname;
	private String uedescription;
	private String ueventstartdate;
	
	public ArrayList<UpcomingEventData> getAllUpcomingEvent() throws SQLException{
		
		Connection con=DataConnection.connect();
		String sql="select * from upcoming_event";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
		ArrayList<UpcomingEventData> upcomingevent=new ArrayList<>();
		while(rs.next()){
			UpcomingEventData uevent = new UpcomingEventData();
			uevent.ueventname=rs.getString("ueventname");
			uevent.uedescription=rs.getString("uedescription");
			uevent.ueventstartdate=rs.getString("ueventstartdate");
						
			upcomingevent.add(uevent);
		}
		return upcomingevent;
	} 

	
	public boolean add() throws SQLException{
		Connection con=DataConnection.connect();
		
		//Create SQL Query
		String sql="insert into upcoming_event(ueventname,uedescription,ueventstartdate) values(?,?,?)";
		
		//Create Statement
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, ueventname);
		ps.setString(2, uedescription);
		ps.setString(3,ueventstartdate);
		
		
		//Execute Statement
		int xx=ps.executeUpdate();
		
		return xx>0;
	}
	
	public int getUeventid() {
		return ueventid;
	}

	public void setUeventid(int ueventid) {
		this.ueventid = ueventid;
	}

	public String getUeventname() {
		return ueventname;
	}

	public void setUeventname(String ueventname) {
		this.ueventname = ueventname;
	}

	public String getUedescription() {
		return uedescription;
	}

	public void setUedescription(String uedescription) {
		this.uedescription = uedescription;
	}

	public String getUeventstartdate() {
		return ueventstartdate;
	}

	public void setUeventstartdate(String ueventstartdate) {
		this.ueventstartdate = ueventstartdate;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s %s",	ueventid,uedescription,ueventname,ueventstartdate);
	}
		
}

