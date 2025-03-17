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

public class AddEmployeeAdminServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("nm");
		String email = req.getParameter("em");
		String pass = req.getParameter("pwd");
		int age = Integer.parseInt(req.getParameter("ag"));
		String add = req.getParameter("add");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?user=root&&password=root");
			PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, pass);
			ps.setInt(5, age);
			ps.setString(6, add);
			ps.executeUpdate();

			RequestDispatcher rd=req.getRequestDispatcher("adminDashboard.html");
			rd.forward(req, resp);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
