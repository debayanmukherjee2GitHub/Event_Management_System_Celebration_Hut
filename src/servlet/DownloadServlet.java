package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;

@WebServlet("/downloadCV")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int empId = Integer.parseInt(req.getParameter("empid"));

		PrintWriter out = resp.getWriter();
		// resp.setContentType(note.getContentType());
		resp.setHeader("Content-Disposition",
				"attachment; filename=\"cv.docx\"");

		Employee emp = new Employee();

		InputStream is;
		try {
			is = emp.getEmployeeById(empId).getEmpcv();

			int i;
			while ((i = is.read()) != -1) {
				out.write(i);
			}
			is.close();
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
