package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bean.EventPic;

@WebServlet(urlPatterns="/addImage")
@MultipartConfig
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String msg="";
		
		try {
				
				Part part=req.getPart("epicimage");
				String filename=part.getSubmittedFileName();	
				
			
				
				
				
				if((!filename.endsWith(".jpg") )&&(!filename.endsWith(".png"))){
						msg="Unsupported file extensions..."+" | "+filename;
						throw new Exception(msg);
				}	
						
				EventPic epic=new EventPic();
				epic.setEpictitle(req.getParameter("epictitle"));
				epic.setEpicdescription(req.getParameter("epicdescription"));
				epic.setEpicimage(part.getInputStream());
				epic.setFilename(filename);
				
				boolean added=epic.add();
					
				//Display Result
				if(added){
					msg="Event Image Successfully Added ...";
				}else{
					msg="Please Re-enter Information Correctly ...";
				}
			
		} catch (Exception e) {
			msg=e.getMessage();
		}
		
		req.setAttribute("msg", msg);
		RequestDispatcher rd=req.getRequestDispatcher("eventPic.jsp");
		rd.forward(req, resp);	
	}

}
