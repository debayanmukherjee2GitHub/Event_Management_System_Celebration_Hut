package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PlaceOrder;

@WebServlet(urlPatterns="/addOrder")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String msg="";
		
		try {
				
				PlaceOrder order=new PlaceOrder();
				order.setUid(Integer.parseInt(req.getParameter("uid")));
				order.setOrderhname(req.getParameter("orderhname"));
				order.setOrderhaddress(req.getParameter("orderhaddress"));
				order.setOrderdate(req.getParameter("orderdate"));
				order.setOrdertype(req.getParameter("ordertype"));
				order.setOrderdecor(req.getParameter("orderdecor"));
				order.setOrdercaterer(req.getParameter("ordercaterer"));
				order.setOrdermenu(req.getParameter("ordermenu"));
				order.setOrdergate(req.getParameter("ordergate"));
				order.setOrdercar(req.getParameter("ordercar"));
				order.setOrdernocar(Integer.parseInt(req.getParameter("ordernocar")));
				order.setOrderentertainer(req.getParameter("orderentertainer"));
				order.setOrderdj(req.getParameter("orderdj"));
				order.setOrdercamera(req.getParameter("ordercamera"));
				
				boolean added=order.add();
					
				//Display Result
				if(added){
					msg="Order Placed ...";
				}else{
					msg="Please Re-enter Information Correctly ...";
				}
			
		} catch (Exception e) {
			msg=e.getMessage();
		}
		
		req.setAttribute("msg", msg);
		RequestDispatcher rd=req.getRequestDispatcher("placeOrder.jsp");
		rd.forward(req, resp);	
	}
}
	