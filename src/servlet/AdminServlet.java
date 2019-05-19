package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admin;

@WebServlet(urlPatterns={"/addAdmin","/adminLogin","/adminlogout"})
public class AdminServlet extends HttpServlet {
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
		String redirectPage="adminInsert.jsp";
		try {				
				Admin admin=new Admin();
				HttpSession hs=req.getSession();
				switch(url){
					case "addAdmin":
						redirectPage="adminInsert.jsp";
						admin.setAdminname(req.getParameter("adminname"));
						admin.setAdminpassword(req.getParameter("adminpassword"));
						admin.setAdminconfirmpasword(req.getParameter("adminconfirmpassword"));
						
						
						if(req.getParameter("adminpassword").equals(req.getParameter("adminconfirmpassword"))){
							boolean added=admin.add();
						//Display Result
							if(added){
								msg=" Admin Successfully Added ...";
							}
							else{
								msg="Please Re-enter Information Correctly ...";
							}
						}
						else{
							msg="Password Does not match ... ";
						}
						break;
					case "adminLogin":
						redirectPage="adminLogin.jsp";
						admin.setAdminid(Integer.parseInt(req.getParameter("adminid")));
						admin.setAdminpassword(req.getParameter("adminpassword"));
						
						if(admin.login()==true){
							
							hs.setAttribute("adminlog", admin.getAdminid());
							redirectPage="adminHome.jsp";
						}else{
							msg="invalid adminid/adminpassword";
						}
						
						break;
					case "adminlogout":
						hs.invalidate();
						redirectPage="adminLogin.jsp";
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
