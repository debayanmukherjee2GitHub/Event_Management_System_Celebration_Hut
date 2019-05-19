package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;

@WebServlet(urlPatterns={"/addCustomer","/customerLogin","/customerLogout"})
public class CustomerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String msg="";
		String url=req.getRequestURL().toString();
		url=url.substring(url.lastIndexOf("/")+1);
		String redirectPage="customerLogin.jsp";
		
		try {
			Customer customer= new Customer();
			HttpSession hs= req.getSession();
			switch(url){
			case "addCustomer":
				customer.setUfanme(req.getParameter("ufname"));
				customer.setUlname(req.getParameter("ulname"));
				customer.setUdob(req.getParameter("udob"));
				customer.setUgender(req.getParameter("ugender"));
				customer.setUmail(req.getParameter("umail"));
				customer.setUcontact(Long.parseLong(req.getParameter("ucontact")));
				customer.setUlocation(req.getParameter("ulocation"));
				customer.setUpassword(req.getParameter("upassword"));
				customer.setUconfirmpassword(req.getParameter("uconfirmpassword"));
						
				if((req.getParameter("upassword")).equals(req.getParameter("uconfirmpassword"))){
					
					boolean added=customer.add();
					
					//Display Result
					if(added){
						msg="Thank you for registering ...";
					}
					else{
						msg="Please Re-enter Information Correctly ...";
					}
				}
				else{
					msg="Password Doesn't Match ...";
				}
				break;
				
			case "customerLogin":
				redirectPage="customerLogin.jsp";
				customer.setUid(Integer.parseInt(req.getParameter("uid")));
				customer.setUpassword(req.getParameter("upassword"));
				
				if(customer.login()==true){
					
					hs.setAttribute("customerlog", customer.getUid());
					redirectPage="placeOrder.jsp";
				}else{
					msg="invalid Customer id/password";
				}
				break;
				
			case "customerLogout":
				hs.invalidate();
				redirectPage="customerLogin.jsp";
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg="ERROR: "+e.getMessage();
		}
		
		req.setAttribute("msg", msg);
		RequestDispatcher rd=req.getRequestDispatcher(redirectPage);
		rd.forward(req, resp);	
	}
}