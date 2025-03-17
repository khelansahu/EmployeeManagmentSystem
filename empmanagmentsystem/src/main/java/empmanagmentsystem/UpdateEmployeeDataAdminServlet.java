package empmanagmentsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateEmployeeDataAdminServlet extends HttpServlet{

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("nm");
		String email=req.getParameter("em");
		String pass=req.getParameter("pwd");
		int age=Integer.parseInt(req.getParameter("age"));
		String address=req.getParameter("add");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?user=root&&password=root");
			PreparedStatement ps=con.prepareStatement("update emp set id=?, name=?, password=?, age=?, address=? where email=?");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, pass);
			ps.setInt(4, age);
			ps.setString(5, address);
			ps.setString(6, email);
			ps.executeUpdate();
			PrintWriter pw=resp.getWriter();
			RequestDispatcher rd=req.getRequestDispatcher("ViewAllEmployeeServlet");
			rd.forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
