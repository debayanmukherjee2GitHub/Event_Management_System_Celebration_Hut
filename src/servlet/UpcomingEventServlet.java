package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.UpcomingEventData;

@WebServlet(urlPatterns="/addUpcomingEvent")
public class UpcomingEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String msg="";
		
		try {				
				UpcomingEventData event=new UpcomingEventData();
				event.setUeventname(req.getParameter("ueventname"));
				event.setUedescription(req.getParameter("uedescription"));
				event.setUeventstartdate(req.getParameter("ueventstartdate"));
				
				System.out.println("ev det: "+event);
				
				boolean added=event.add();
					
				//Display Result
				if(added){
					msg="Upcoming Event Successfully Added ...";
				}else{
					msg="Please Re-enter Information Correctly ...";
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg=e.getMessage();
		}
		
		req.setAttribute("msg", msg);
		RequestDispatcher rd=req.getRequestDispatcher("upcomingEvent.jsp");
		rd.forward(req, resp);	
	}

}
