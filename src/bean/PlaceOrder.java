package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.DataConnection;

public class PlaceOrder {
	public int orderid;
	public int uid;
	public String orderhname;
	public String orderhaddress;
	public String orderdate;
	public String ordertype;
	public String orderdecor;
	public String ordercaterer;
	public String ordermenu;
	public String ordergate;
	public String ordercar;
	public int ordernocar;
	public String orderentertainer;
	public String orderdj;
	public String ordercamera;
	
	public ArrayList<PlaceOrder> getAllPlaceOrder() throws SQLException{
		Connection con=DataConnection.connect();
		String sql="select * from `order` where 1";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
		ArrayList<PlaceOrder> order=new ArrayList<>();
		while(rs.next()){
			PlaceOrder ord = new PlaceOrder();
			ord.orderid=rs.getInt("orderid");
			ord.uid=rs.getInt("uid");
			ord.orderhname=rs.getString("orderhname");
			ord.orderhaddress=rs.getString("orderhaddress");
			ord.orderdate=rs.getString("orderdate");
			ord.ordertype=rs.getString("ordertype");
			ord.orderdecor=rs.getString("orderdecor");
			ord.ordercaterer=rs.getString("ordercaterer");
			ord.ordermenu=rs.getString("ordermenu");
			ord.ordergate=rs.getString("ordergate");
			ord.ordercar=rs.getString("ordercar");
			ord.ordernocar=rs.getInt("ordernocar");
			ord.orderentertainer=rs.getString("orderentertainer");
			ord.orderdj=rs.getString("orderdj");
			ord.ordercamera=rs.getString("ordercamera");
			
			order.add(ord);
			
		}
		return order;
		
	}
	
	
	public boolean add() throws SQLException{
		Connection con=DataConnection.connect();
		
		//Create SQL Query
		String sql="insert into `order`(uid,orderhname,orderhaddress,"
				+ "orderdate,ordertype,orderdecor,ordercaterer,ordermenu,"
				+ "ordergate,ordercar,ordernocar,orderentertainer,orderdj,"
				+ "ordercamera) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		
		//Create Statement
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, uid);
		ps.setString(2, orderhname);
		ps.setString(3, orderhaddress);
		ps.setString(4, orderdate);
		ps.setString(5, ordertype);
		ps.setString(6, orderdecor);
		ps.setString(7, ordercaterer);
		ps.setString(8, ordermenu);
		ps.setString(9, ordergate);
		ps.setString(10, ordercar);
		ps.setInt(11, ordernocar);
		ps.setString(12, orderentertainer);
		ps.setString(13, orderdj);
		ps.setString(14, ordercamera);
		
		
		//Execute Statement
		int xx=ps.executeUpdate();
		
		return xx>0;
	}
	
	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getOrderhname() {
		return orderhname;
	}

	public void setOrderhname(String orderhname) {
		this.orderhname = orderhname;
	}

	public String getOrderhaddress() {
		return orderhaddress;
	}

	public void setOrderhaddress(String orderhaddress) {
		this.orderhaddress = orderhaddress;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public String getOrderdecor() {
		return orderdecor;
	}

	public void setOrderdecor(String orderdecor) {
		this.orderdecor = orderdecor;
	}

	public String getOrdercaterer() {
		return ordercaterer;
	}

	public void setOrdercaterer(String ordercaterer) {
		this.ordercaterer = ordercaterer;
	}

	public String getOrdermenu() {
		return ordermenu;
	}

	public void setOrdermenu(String ordermenu) {
		this.ordermenu = ordermenu;
	}

	public String getOrdergate() {
		return ordergate;
	}

	public void setOrdergate(String ordergate) {
		this.ordergate = ordergate;
	}

	public String getOrdercar() {
		return ordercar;
	}

	public void setOrdercar(String ordercar) {
		this.ordercar = ordercar;
	}

	public void setOrdernocar(int ordernocar) {
		this.ordernocar = ordernocar;
	}

	public int getOrdernocar() {
		return ordernocar;
	}

	public String getOrderentertainer() {
		return orderentertainer;
	}

	public void setOrderentertainer(String orderentertainer) {
		this.orderentertainer = orderentertainer;
	}

	public String getOrderdj() {
		return orderdj;
	}

	public void setOrderdj(String orderdj) {
		this.orderdj = orderdj;
	}

	public String getOrdercamera() {
		return ordercamera;
	}

	public void setOrdercamera(String ordercamera) {
		this.ordercamera = ordercamera;
	}
	
}
