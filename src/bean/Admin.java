package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DataConnection;

public class Admin {

	private int adminid;
	private String adminname;
	private String adminpassword;
	private String adminconfirmpasword;
	
	public boolean login() throws SQLException{
		Connection con=DataConnection.connect();
		String sql="select * from admin where adminid=? and adminpassword=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, adminid);
		ps.setString(2, adminpassword);
		
		ResultSet rs=ps.executeQuery();
			
		return rs.next();
	}
	
	public boolean add() throws SQLException{
		Connection con=DataConnection.connect();
		
		//Create SQL Query
		String sql="insert into admin(adminname,adminpassword,adminconfirmpassword) values(?,?,?)";
		
		//Create Statement
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, adminname);
		ps.setString(2, adminpassword);
		ps.setString(3, adminconfirmpasword);
		
		
		
		//Execute Statement
		int xx=ps.executeUpdate();
		
		return xx>0;
	}
	
	public Admin getAdminById(int adminId) throws SQLException{
		System.out.println("Ad ID: "+adminId);
		Connection con=DataConnection.connect();
		String sql="select * from admin where adminid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, adminId);
		
		ResultSet rs=ps.executeQuery();
			
		rs.next();
		
		Admin admin=new Admin();
		admin.setAdminid(rs.getInt("adminid"));
		admin.setAdminname(rs.getString("adminname"));
		
		return admin; 
	}
	
	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	public String getAdminconfirmpasword() {
		return adminconfirmpasword;
	}

	public void setAdminconfirmpasword(String adminconfirmpasword) {
		this.adminconfirmpasword = adminconfirmpasword;
	}
		
}

