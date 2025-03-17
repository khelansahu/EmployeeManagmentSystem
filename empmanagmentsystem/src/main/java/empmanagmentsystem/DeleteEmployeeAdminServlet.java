package empmanagmentsystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteEmployeeAdminServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 HttpSession session=req.getSession();
		String email=req.getParameter("em");
//		 String email=(String)session.getAttribute("email");
//		 PrintWriter pw=resp.getWriter();
		 
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?user=root&&password=root");
				PreparedStatement ps=con.prepareStatement("delete from emp where email=?");
				ps.setString(1,email);	
				ps.executeUpdate();
//				resp.sendRedirect("ViewAllEmployeeServlet");
				RequestDispatcher rd=req.getRequestDispatcher("ViewAllEmployeeServlet");
				rd.forward(req, resp);
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}

	}
}
