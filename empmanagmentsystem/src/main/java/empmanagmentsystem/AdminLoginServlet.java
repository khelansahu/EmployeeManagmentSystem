package empmanagmentsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					String email=req.getParameter("em");
					String pass=req.getParameter("pwd");
					PrintWriter pw=resp.getWriter();
					if (email.equals("admin@gmail.com")&&pass.equals("admin123")) {
						resp.sendRedirect("adminDashboard.html");
					}else {
			            pw.println("<h3>Invalid Credentials</h3>");
			            RequestDispatcher rd=req.getRequestDispatcher("adminLogin.html");
			            rd.forward(req, resp);
			            
			        }
}
}
