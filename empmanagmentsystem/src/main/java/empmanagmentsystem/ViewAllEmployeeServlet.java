package empmanagmentsystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewAllEmployeeServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
	     PreparedStatement ps = con.prepareStatement("select * from emp");
	     ResultSet rs = ps.executeQuery();
	     PrintWriter pw=resp.getWriter();
	     
//	     pw.println("<html><head><title>Employee Details</title></head><body>");
//         pw.println("<h2>All Employees</h2>");
//         pw.println("<table border='1' cellpadding='10'>");
//         pw.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Age</th><th>Address</th><th>Password</th><th>Action</th></tr>");
//
//         while (rs.next()) {
//        	 String email=rs.getString("email");
//             pw.println("<tr>");
//             pw.println("<td>" + rs.getInt("id") + "</td>");
//             pw.println("<td>" + rs.getString("name") + "</td>");
//             pw.println("<td>" + email + "</td>");
//             pw.println("<td>" + rs.getInt("age") + "</td>");
//             pw.println("<td>" + rs.getString("address") + "</td>");
//             pw.println("<td>" + rs.getString("password") + "</td>");
//            pw.println( "<td><form action='UpdateEmployeeAdminServlet' method='post' style='display:inline;'>"
//                    + "<input type='hidden' name='em' value='" +email + "'>"
//                    + "<button>Edit</button>"
//                    + "</form> </td>");
//            pw.println("<td><form action='DeleteEmployeeAdminServletConfirm' method='post' style='display:inline;'>"
//            		+ "<input type='hidden' name='em' value='" +email+"'>"
//            		+ "<button>Delete</button>"
//            		+ "</form></td>");
//             pw.println("</tr>");
//         }
//
//         pw.println("</table>");
//         pw.println("<br><a href='adminDashboard.html'><button>Back to Dashboard</button></a>");
//         pw.println("</body></html>");

	     
	     pw.println("<html><head><title>Employee Details</title>");
	     pw.println("<style>"
	             + "body { display: flex; flex-direction: column; align-items: center; padding: 20px; "
	             + "background: linear-gradient(45deg, #4d50f1, #aeb5d2); font-family: Arial, sans-serif; }"
	             + "h2 { color: white; text-shadow: 2px 2px 4px rgba(0,0,0,0.5); }"
	             + "table { border-collapse: collapse; width: 80%; background-color: white; "
	             + "box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.5); border-radius: 10px; overflow: hidden; margin-top: 20px; }"
	             + "th, td { padding: 15px; text-align: left; border-bottom: 1px solid #ddd; }"
	             + "th { background-color: #2c3e50; color: white; font-size: 18px; }"
	             + "tr:nth-child(even) { background-color: #f2f2f2; }"
	             + "button { font-size: 16px; padding: 8px 15px; border-radius: 8px; border: none; cursor: pointer; color: white; }"
	             + ".edit-btn { background: linear-gradient(45deg, #4d50f1, #405ac2); }"
	             + ".delete-btn { background: linear-gradient(45deg, #ff4d4d, #d33c3c); }"
	             + ".edit-btn:hover, .delete-btn:hover, .back-btn:hover { transform: scale(1.05); transition: 0.3s ease-in-out; }"
	             + ".button-container { text-align: center; margin-top: 20px; }"
	             + ".back-btn { background: linear-gradient(45deg, #4d50f1, #405ac2); font-size: 18px; padding: 10px 20px; }"
	             + "</style></head><body>");

	     pw.println("<h2>All Employees</h2>");
	     pw.println("<table>");
	     pw.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Age</th><th>Address</th><th>Password</th><th>Actions</th></tr>");

	     while (rs.next()) {
	         String email = rs.getString("email");
	         pw.println("<tr>");
	         pw.println("<td>" + rs.getInt("id") + "</td>");
	         pw.println("<td>" + rs.getString("name") + "</td>");
	         pw.println("<td>" + email + "</td>");
	         pw.println("<td>" + rs.getInt("age") + "</td>");
	         pw.println("<td>" + rs.getString("address") + "</td>");
	         pw.println("<td>" + rs.getString("password") + "</td>");
	         pw.println("<td>"
	                 + "<form action='UpdateEmployeeAdminServlet' method='post' style='display:inline;'>"
	                 + "<input type='hidden' name='em' value='" + email + "'>"
	                 + "<button class='edit-btn'>Edit</button>"
	                 + "</form> "
	                 + "<form action='DeleteEmployeeAdminServletConfirm' method='post' style='display:inline;'>"
	                 + "<input type='hidden' name='em' value='" + email + "'>"
	                 + "<button class='delete-btn'>Delete</button>"
	                 + "</form>"
	                 + "</td>");
	         pw.println("</tr>");
	     }

	     pw.println("</table>");
	     pw.println("<div class='button-container'><a href='adminDashboard.html'><button class='back-btn'>Back to Dashboard</button></a></div>");
	     pw.println("</body></html>");

	} catch (ClassNotFoundException | SQLException e) {

		e.printStackTrace();
	}
    
}
}
