package empmanagmentsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateEmployeeDataServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	String Strid=req.getParameter("id");
	String name=req.getParameter("nm");
	String email=req.getParameter("em");
	String pass=req.getParameter("pwd");
	String Strage= req.getParameter("age");
	String address=req.getParameter("add");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?user=root&&password=root");
		PreparedStatement pss=con.prepareStatement("select * from emp where email=?");
		pss.setString(1, email);
		ResultSet rs=pss.executeQuery();
		if (rs.next()) {
			if (Strid==null || Strid.isEmpty()) {
				Strid = Integer.toString(rs.getInt("id"));
			}
			if (name==null  || name.isEmpty() ) {
				name = rs.getString("name");
			}
			if (email==null || email.isEmpty()) {
				email = rs.getString("email");
			}
			if (pass==null || pass.isEmpty()) {
				pass = rs.getString("password");
			}
			if (Strage==null || Strage.isEmpty()) {
				Strage = Integer.toString(rs.getInt("age"));
			}
			if (address==null || address.isEmpty()) {
				address = rs.getString("address");
			}
			
		}
		int id= Integer.parseInt(Strid);
		int age=Integer.parseInt(Strage);
		
		PreparedStatement ps=con.prepareStatement("update emp set id=?, name=?, password=?, age=?, address=? where email=?");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, pass);
		ps.setInt(4, age);
		ps.setString(5, address);
		ps.setString(6, email);
		ps.executeUpdate();
		PrintWriter pw=resp.getWriter();
		RequestDispatcher rd=req.getRequestDispatcher("login");
		rd.forward(req, resp);
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
}

}
