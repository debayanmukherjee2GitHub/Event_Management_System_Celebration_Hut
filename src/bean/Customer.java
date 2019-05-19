package bean;

import java.sql.*;
import java.util.*;

import util.DataConnection;

public class Customer {
		private int uid;
		private String ufname;
		private String ulname;
		private String ugender;
		private String udob;
		private String umail;
		public long ucontact;
		public String ulocation;
		public String upassword;
		public String uconfirmpassword;
		
		
		public ArrayList<Customer> getAllUid() throws SQLException{
			Connection con=DataConnection.connect();
			String sql="select MAX(uid) AS uid from customer";
			Statement stmt=con.createStatement();			
			ResultSet rs=stmt.executeQuery(sql);
			
			ArrayList<Customer> customer=new ArrayList<>();
			while(rs.next()){
				Customer cust=new Customer();
				cust.uid=rs.getInt("uid");
				
				customer.add(cust);
			}
			return customer;
			
		}
	
		public ArrayList<Customer> getAllCustomer() throws SQLException{
			Connection con=DataConnection.connect();
			String sql="select * from customer";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			ArrayList<Customer> customer=new ArrayList<>();
			while(rs.next()){
				Customer cust=new Customer();
				cust.uid=rs.getInt("uid");
				cust.ufname=rs.getString("ufname");
				cust.ulname=rs.getString("ulname");
				cust.ugender=rs.getString("ugender");
				cust.udob=rs.getString("udob");
				cust.umail=rs.getString("umail");
				cust.ucontact=rs.getLong("ucontact");
				cust.ulocation=rs.getString("ulocation");
								
				customer.add(cust);
			}
			return customer;
		}
				
		
		public boolean login() throws SQLException{
			Connection con=DataConnection.connect();
			String sql="select * from customer where uid=? and upassword=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, uid);
			ps.setString(2, upassword);
			
			ResultSet rs=ps.executeQuery();
				
			return rs.next();
		}
		
		
		public boolean add() throws SQLException{
			Connection con=DataConnection.connect();
			
			//Create SQL Query
			String sql="insert into customer(ufname,ulname,udob,ugender,umail,ucontact,ulocation,"
					+ "upassword,uconfirmpassword) values(?,?,?,?,?,?,?,?,?)";
			
			//Create Statement
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, ufname);
			ps.setString(2, ulname);
			ps.setString(3, udob);
			ps.setString(4, ugender);
			ps.setString(5, umail);
			ps.setLong(6, ucontact);
			ps.setString(7, ulocation);
			ps.setString(8, upassword);
			ps.setString(9, uconfirmpassword);
			
			//Execute Statement
			int xx=ps.executeUpdate();
			
			return xx>0;
		}
		
		
		public Customer getCustomerById(int uId) throws SQLException{
			System.out.println("Ad ID: "+uId);
			Connection con=DataConnection.connect();
			String sql="select * from customer where uid=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, uId);
			
			ResultSet rs=ps.executeQuery();
				
			rs.next();
			
			Customer customer=new Customer();
			customer.setUid(rs.getInt("uid"));
			customer.setUfname(rs.getString("ufname"));
			
			return customer; 
		}
		
		
		
		public int getUid() {
			return uid;
		}


		public void setUid(int uid) {
			this.uid = uid;
		}
		
		public void setUfanme(String ufanme) {
			this.ufname = ufanme;
		}
		
		public String getUfname() {
			return ufname;
		}

		public void setUfname(String ufname) {
			this.ufname = ufname;
		}

		public String getUgender() {
			return ugender;
		}

		public void setUgender(String ugender) {
			this.ugender = ugender;
		}


		public String getUlname() {
			return ulname;
		}


		public void setUlname(String ulname) {
			this.ulname = ulname;
		}


		public String getUdob() {
			return udob;
		}


		public void setUdob(String udob) {
			this.udob = udob;
		}


		public String getUmail() {
			return umail;
		}


		public void setUmail(String umail) {
			this.umail = umail;
		}


		public long getUcontact() {
			return ucontact;
		}


		public void setUcontact(long ucontact) {
			this.ucontact = ucontact;
		}


		public String getUlocation() {
			return ulocation;
		}


		public void setUlocation(String ulocation) {
			this.ulocation = ulocation;
		}


		public String getUpassword() {
			return upassword;
		}


		public void setUpassword(String upassword) {
			this.upassword = upassword;
		}


		public String getUconfirmpassword() {
			return uconfirmpassword;
		}


		public void setUconfirmpassword(String uconfirmpassword) {
			this.uconfirmpassword = uconfirmpassword;
		}
}
