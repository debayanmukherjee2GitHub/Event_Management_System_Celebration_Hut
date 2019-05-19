package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import bean.Employee;

@WebServlet(urlPatterns={"/addEmployee","/emplogin","/emplogout"})
@MultipartConfig
public class EmployeeServlet extends HttpServlet {
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
		String redirectPage="empLogin.jsp";
		
		try {
			Employee emp=new Employee();
			HttpSession hs= req.getSession();
			switch(url){
			case "addEmployee":
				Part partphoto=req.getPart("empphoto");
				String photo=partphoto.getSubmittedFileName();	
				
				Part partcv=req.getPart("empcv");
				String cv=partcv.getSubmittedFileName();
			
				if((!photo.endsWith(".jpg"))&&(!photo.endsWith(".JPEG"))&&
						(!photo.endsWith(".png"))&&(!photo.endsWith(".JPG"))){
						msg="Unsupported file extensions..."+" | "+photo;
						throw new Exception(msg);
				}	
						
				
				if((!cv.endsWith(".doc") )&&(!cv.endsWith(".docx")&&(!cv.endsWith(".pdf")))){
						msg="Unsupported file extensions..."+" | "+cv;
						throw new Exception(msg);
				}	
				
				emp.setEmpfname(req.getParameter("empfname"));
				emp.setEmplname(req.getParameter("emplname"));
				emp.setEmpaddress(req.getParameter("empaddress"));
				emp.setEmpdob(req.getParameter("empdob"));
				emp.setEmpgender(req.getParameter("empgender"));
				emp.setEmpmail(req.getParameter("empmail"));
				emp.setEmpcontact(Long.parseLong(req.getParameter("empcontact")));
				emp.setEmphq(req.getParameter("emphq"));	
				emp.setEmpphoto(partphoto.getInputStream());
				emp.setPhotofilename(photo);
				emp.setEmpcv(partcv.getInputStream());
				emp.setCvfilename(cv);
				emp.setEmppassword(req.getParameter("emppassword"));
				emp.setEmpconfirmpassword(req.getParameter("empconfirmpassword"));
								
				if((req.getParameter("emppassword")).equals(req.getParameter("empconfirmpassword"))){
					
					boolean added=emp.add();
					
					//Display Result
					if(added){
						msg="Employee Application Sent [Log in your account for authentication news] ...";
						
					}
					else{
						msg="Please Re-enter Information Correctly ...";
					}
				}
				else{
					msg="Password Doesn't Match ...";
				}
				
				break;
			case "emplogin":
				redirectPage="empLogin.jsp";
				emp.setEmpid(Integer.parseInt(req.getParameter("empid")));
				emp.setEmppassword(req.getParameter("emppassword"));
				
				if(emp.login()==true){
					
					hs.setAttribute("emplog", emp.getEmpid());
					redirectPage="empHome.jsp";
				}else{
					msg="invalid empid/empppassword";
				}
				break;
				
			case "emplogout":
				hs.invalidate();
				redirectPage="empLogin.jsp";
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