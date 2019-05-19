package bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Base64;
import util.DataConnection;

public class Employee {
	private int empid;
	private String empfname;
	private String emplname;
	private String empaddress;
	private String empdob;
	private String empgender;
	private String empmail;
	private long empcontact;
	private String emphq;
	private InputStream empphoto;
	private String photofilename;
	private InputStream empcv;
	private String cvfilename;
	private String emppassword;
	private String empconfirmpassword;
	
	protected boolean getAllPhoto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         try {
            Connection conn =  DataConnection.connect();
            PreparedStatement ps = conn.prepareStatement("select empphoto from "
            													+ "employee where empid=?");
            String empid = request.getParameter("empid");
            ps.setString(1,empid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            Blob  b = rs.getBlob("empphoto");            
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
	
	
	public ArrayList<Employee> getAllEmployee() throws SQLException{
	
			Connection con=DataConnection.connect();
			String sql="select * from employee";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			ArrayList<Employee> employee=new ArrayList<>();
			while(rs.next()){
				Employee emp=new Employee();
				emp.empid=rs.getInt("empid");
				emp.empfname=rs.getString("empfname");
				emp.emplname=rs.getString("emplname");
				emp.empaddress=rs.getString("empaddress");
				emp.empdob=rs.getString("empdob");
				emp.empgender=rs.getString("empgender");
				emp.empmail=rs.getString("empmail");
				emp.empcontact=rs.getLong("empcontact");
				emp.emphq=rs.getString("emphq");
				emp.empphoto=rs.getBinaryStream("empphoto");
				emp.empcv=rs.getBinaryStream("empcv");
							
				employee.add(emp);
			}
			return employee;
	} 
	
	public String getImageAsString() throws IOException{
		byte []buff=new byte[this.empphoto.available()];
		
		this.empphoto.read(buff);
		
		String imgString=Base64.encodeBytes(buff);
		buff=null;
		return imgString;
	}
	
	public boolean login() throws SQLException{
		Connection con=DataConnection.connect();
		String sql="select * from employee where empid=? and emppassword=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, empid);
		ps.setString(2, emppassword);
		
		ResultSet rs=ps.executeQuery();
			
		return rs.next();
	}
	
	
	public boolean add() throws SQLException{
		Connection con=DataConnection.connect();
		
		//Create SQL Query
		String sql="insert into employee(empfname,emplname,empaddress,empdob,"
				+ "empgender,empmail,empcontact,emphq,empphoto,photofilename,empcv,"
				+ "cvfilename,emppassword,empconfirmpassword) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		//Create Statement
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, empfname);
		ps.setString(2, emplname);
		ps.setString(3,empaddress);
		ps.setString(4, empdob);
		ps.setString(5, empgender);
		ps.setString(6, empmail);
		ps.setLong(7, empcontact);
		ps.setString(8, emphq);
		ps.setBinaryStream(9, empphoto);
		ps.setString(10, photofilename);
		ps.setBinaryStream(11, empcv);
		ps.setString(12, cvfilename);
		ps.setString(13, emppassword);
		ps.setString(14, empconfirmpassword);
		
		//Execute Statement
		int xx=ps.executeUpdate();
		
		return xx>0;
	}
	public Employee getEmployeeById(int empId) throws SQLException{
		System.out.println("Ad ID: "+empId);
		Connection con=DataConnection.connect();
		String sql="select * from employee where empid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, empId);
		
		ResultSet rs=ps.executeQuery();
			
		rs.next();
		
		Employee emp=new Employee();
		
		emp.empid=rs.getInt("empid");
		emp.empfname=rs.getString("empfname");
		emp.emplname=rs.getString("emplname");
		emp.empaddress=rs.getString("empaddress");
		emp.empdob=rs.getString("empdob");
		emp.empgender=rs.getString("empgender");
		emp.empmail=rs.getString("empmail");
		emp.empcontact=rs.getLong("empcontact");
		emp.emphq=rs.getString("emphq");
		emp.empphoto=rs.getBinaryStream("empphoto");
		emp.empcv=rs.getBinaryStream("empcv");
		
		return emp; 
	}
	

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpfname() {
		return empfname;
	}
	public void setEmpfname(String empfname) {
		this.empfname = empfname;
	}
	public String getEmplname() {
		return emplname;
	}
	public void setEmplname(String emplname) {
		this.emplname = emplname;
	}
	public String getEmpaddress() {
		return empaddress;
	}
	public void setEmpaddress(String empaddress) {
		this.empaddress = empaddress;
	}
	public String getEmpdob() {
		return empdob;
	}
	public void setEmpdob(String empdob) {
		this.empdob = empdob;
	}
	public String getEmpgender() {
		return empgender;
	}
	public void setEmpgender(String empgender) {
		this.empgender = empgender;
	}
	public String getEmpmail() {
		return empmail;
	}
	public void setEmpmail(String empmail) {
		this.empmail = empmail;
	}
	public long getEmpcontact() {
		return empcontact;
	}
	public void setEmpcontact(long l) {
		this.empcontact = l;
	}
	public String getEmphq() {
		return emphq;
	}
	public void setEmphq(String emphq) {
		this.emphq = emphq;
	}
	public InputStream getEmpphoto() {
		return empphoto;
	}
	public void setEmpphoto(InputStream inputStream) {
		this.empphoto = inputStream;
	}
	public InputStream getEmpcv() {
		return empcv;
	}
	public void setEmpcv(InputStream empcv) {
		this.empcv = empcv;
	}
	public String getEmppassword() {
		return emppassword;
	}
	public void setEmppassword(String emppassword) {
		this.emppassword = emppassword;
	}
	public String getEmpconfirmpassword() {
		return empconfirmpassword;
	}
	public void setEmpconfirmpassword(String empconfirmpassword) {
		this.empconfirmpassword = empconfirmpassword;
	}

	public String getPhotofilename() {
		return photofilename;
	}

	public void setPhotofilename(String photofilename) {
		this.photofilename = photofilename;
	}

	public String getCvfilename() {
		return cvfilename;
	}

	public void setCvfilename(String cvfilename) {
		this.cvfilename = cvfilename;
	}
}
