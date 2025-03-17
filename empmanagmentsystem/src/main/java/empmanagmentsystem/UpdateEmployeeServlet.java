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
import javax.servlet.http.HttpSession;

public class UpdateEmployeeServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("em");
	PrintWriter pw=resp.getWriter();
	HttpSession session=req.getSession();
//	String email=(String) session.getAttribute("email");
//	System.out.println(email);
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
         PreparedStatement ps = con.prepareStatement("SELECT * FROM emp WHERE email = ?");
         ps.setString(1, email);
         ResultSet rs = ps.executeQuery();
         
         if (rs.next()) {
//        	   pw.println("<html><head><title>Update Employee</title>");
//               pw.println("<style>"
//                       + "body { display: flex; justify-content: center; height: 100vh; background: linear-gradient(45deg, #4d50f1, #aeb5d2); align-items: center; }"
//                       + "form { background: radial-gradient(circle, #5f8fff, #4b66be); padding: 20px; border-radius: 20px; box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.5); text-align: center; width: 50%; }"
//                       + "label { font-size: 20px; font-weight: bold; color: white; display: block; margin: 10px 0 5px; }"
//                       + "input { font-size: 18px; padding: 8px; width: 80%; border-radius: 10px; border: none; background: white; display: block; margin: 0 auto; }"
//                       + "button { font-size: 20px; padding: 10px 30px; border-radius: 20px; background: linear-gradient(45deg, #4d50f1, #405ac2); border: none; cursor: pointer; color: white; margin-top: 20px; }"
//                       + "</style>");
//               pw.println("</head><body>");
//               pw.println("<form action='updatedata' method='post'>"
//                       + "<h2 style='color:white;'>Update Employee Details</h2>"
//                       + "<label>Id:</label> <input type='number' name='id' value='" + rs.getInt("id") + "'><br>"
//                       + "<label>Name:</label> <input type='text' name='nm' value='" + rs.getString("name") + "'><br>"
//                       + "<label>Email:</label> <input type='text' name='em' value='" + rs.getString("email") + "' readonly><br>"
//                       + "<label>Password:</label> <input type='text' name='pwd' value='" + rs.getString("password") + "'><br>"
//                       + "<label>Age:</label> <input type='number' name='age' value='" + rs.getInt("age") + "'><br>"
//                       + "<label>Address:</label> <input type='text' name='add' value='" + rs.getString("address") + "'><br>"
//                       + "<button type='submit'>Save</button>"
//                       + "</form>");
//               pw.println("</body></html>");
        	 
        	 pw.println("<html><head><title>Update Employee</title>");
        	 pw.println("<style>"
        	         + "body { display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; "
        	         + "background: linear-gradient(45deg, #4d50f1, #aeb5d2); }"
        	         + "#form-container { background: radial-gradient(circle, #5f8fff, #4b66be); padding: 20px; border-radius: 15px; "
        	         + "box-shadow: 8px 8px 15px rgba(0, 0, 0, 0.4); width: 35%; }"
        	         + "h2 { color: white; font-size: 22px; text-align: center; margin-bottom: 10px; }"
        	         + ".form-group { display: flex; align-items: center; margin-bottom: 10px; }"
        	         + "label { font-size: 16px; font-weight: bold; color: white; width: 35%; text-align: left; }"
        	         + "input { font-size: 16px; padding: 8px; width: 60%; border-radius: 10px; border: none; background: white; text-align: left; }"
        	         + "input[readonly] { background: #d3d3d3; color: #555; cursor: not-allowed; font-weight: bold; }"
        	         + ".button-container { text-align: center; margin-top: 15px; }"
        	         + "button { font-size: 18px; padding: 10px 20px; border-radius: 20px; background: linear-gradient(45deg, #4d50f1, #405ac2); "
        	         + "border: none; cursor: pointer; color: white; font-weight: bold; width: 30%; }"
        	         + "button:hover { transform: scale(1.05); transition: 0.3s ease-in-out; }"
        	         + "</style></head><body>");
        	 pw.println("<div id='form-container'>"
        	         + "<h2>Update Employee Details</h2>"
        	         + "<form action='updatedata' method='post'>"
        	         + "<div class='form-group'><label>Employee ID:</label> <input type='number' name='id' value='" + rs.getInt("id") + "'></div>"
        	         + "<div class='form-group'><label>Name:</label> <input type='text' name='nm' value='" + rs.getString("name") + "'></div>"
        	         + "<div class='form-group'><label>Email:</label> <input type='text' name='em' value='" + rs.getString("email") + "' readonly></div>"
        	         + "<div class='form-group'><label>Password:</label> <input type='password' name='pwd' value='" + rs.getString("password") + "'></div>"
        	         + "<div class='form-group'><label>Age:</label> <input type='number' name='age' value='" + rs.getInt("age") + "'></div>"
        	         + "<div class='form-group'><label>Address:</label> <input type='text' name='add' value='" + rs.getString("address") + "'></div>"
        	         + "<div class='button-container'><button type='submit'>Save</button></div>"
        	         + "</form></div>");
        	 pw.println("</body></html>");

        	 
        	 
        	 
         } else {
             pw.println("<html><body><h3>Employee Not Found</h3></html></body>");
         }
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	}
}
