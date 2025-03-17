package empmanagmentsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteEmployeeServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	 HttpSession session=req.getSession();
	 String email=(String)session.getAttribute("email");
//	 PrintWriter pw=resp.getWriter();
	 
	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?user=root&&password=root");
			PreparedStatement ps=con.prepareStatement("delete from emp where email=?");
			ps.setString(1,email);	
			ps.executeUpdate();
			resp.sendRedirect("login.html");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

}
	
}
