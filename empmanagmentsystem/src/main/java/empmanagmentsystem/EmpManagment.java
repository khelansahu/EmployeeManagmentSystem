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

import com.mysql.cj.protocol.Resultset;

public class EmpManagment extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("em");
		String pass = req.getParameter("pwd");
		PrintWriter pw = resp.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?user=root&&password=root");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM emp WHERE email = ? AND password = ?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
					int id = rs.getInt("id");
	                String name = rs.getString("name");
	                int age = rs.getInt("age");
	                String address = rs.getString("address");
	                
	                HttpSession session=req.getSession();
	                session.setAttribute("email", email);
	                session.setAttribute("pass", pass);
	                
//				    pw.println("<table>"
//				    		+ "<tr><th>ID</th><th>Name</th><th>Email</th><th>Age</th><th>Address</th><th>Actions</th></tr>"
//				    		+ "<tr><td>" + id + "</td>"
//				    		+ "<td>" + name+ "</td>"
//				    		+ "<td>" + email+ "</td>"
//				    		+ "<td>" + pass + "</td>"
//				    		+ "<td>" + age + "</td>"
//				    		+ "<td>" + address + "</td>"
//				    		+ "<td>"
//	                        + "<form action='UpdateEmployeeServlet' method='post' style='display:inline;'>"
//	                        + "<input type='hidden' name='em' value='" + email + "'>"
//	                        + "<button type='submit'>Update</button>"
//	                        + "</form> "
//	                        + "<form action='DeleteEmployeeServletConfirm' method='post' style='display:inline;'>"
//	                        + "<input type='hidden' name='em' value='" +email + "'>"
//	                        + "<button type='submit'>Delete</button>"
//	                        + "</form>"
//	                        + "</td>");
//	            pw.println("</table>");
//			} else {
//
//				pw.println("<html><body><div>");
//				pw.println("<h1 style='color:red;'>Wrong email or password </h1>");
//				pw.println("</div></body></html>");
//				RequestDispatcher rd = req.getRequestDispatcher("login.html");
//				rd.include(req, resp);
//			}
	                
	                
	                
//	                pw.println("<html><head><title>Employee Details</title>");
//	                pw.println("<style>"
//	                        + "body { display: flex; justify-content: center; height: 100vh; background: linear-gradient(45deg, #4d50f1, #aeb5d2); }"
//	                        + "table { border-collapse: collapse; width: 70%; height: 40%; background-color: white; box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.5); border-radius: 10px; overflow: hidden; }"
//	                        + "th, td { padding: 15px; text-align: left; border-bottom: 1px solid #ddd; }"
//	                        + "th { background-color: #4b66be; color: white; }"
//	                        + "button { font-size: 20px; padding: 8px 20px; border-radius: 10px; background: linear-gradient(45deg, #4d50f1, #405ac2); border: none; cursor: pointer; color: white; }"
//	                        + "button a { text-decoration: none; color: white; }"
//	                        + "form { display: inline; }"
//	                        + "</style>");
//	                pw.println("</head><body>");
//	                pw.println("<table>");
//	                pw.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Age</th><th>Address</th><th>Password</th><th>Actions</th></tr>");
//	                pw.println("<tr><td>" + id + "</td>"
//	                        + "<td>" + name + "</td>"
//	                        + "<td>" + email + "</td>"
//	                        + "<td>" + age + "</td>"
//	                        + "<td>" + address + "</td>"
//	                          + "<td>" + pass + "</td>"
//	                        + "<td>"
//	                        + "<form action='UpdateEmployeeServlet' method='post' style='display:inline;'>"
//	                        + "<input type='hidden' name='em' value='" + email + "'>"
//	                        + "<button type='submit'>Edit</button>"
//	                        + "</form> "
//	                        + "<form action='DeleteEmployeeServletConfirm' method='post' style='display:inline;'>"
//	                        + "<input type='hidden' name='em' value='" + email + "'>"
//	                        + "<button type='submit'>Delete</button>"
//	                        + "</form>"
//	                        + "</td></tr>");
//	                pw.println("</table>");
//	                pw.println("</body></html>");
	                
	                
	                
	                
	                pw.println("<html><head><title>Employee Details</title>"
	                        + "<style>"
	                        + "body { display: flex; flex-direction: column; align-items: center; height: 100vh; margin: 0; "
	                        + "background: linear-gradient(45deg, #4d50f1, #aeb5d2); font-family: Arial, sans-serif; }"
	                        + "h2 { color: white; margin-top: 20px; font-size: 26px; }"
	                        + "#table-container { width: 80%; margin-top: 20px; }"
	                        + "table { border-collapse: collapse; width: 100%; background: rgba(255, 255, 255, 0.2); "
	                        + "backdrop-filter: blur(12px); border-radius: 15px; overflow: hidden; "
	                        + "box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.5); }"
	                        + "th, td { padding: 15px; text-align: center; border-bottom: 1px solid rgba(255, 255, 255, 0.3); color: white; font-size: 18px; }"
	                        + "th { background: rgba(30, 40, 100, 0.9); font-size: 20px; }" /* Darker background for TH */
	                        + "td { background: rgba(255, 255, 255, 0.1); }"
	                        + "button { font-size: 18px; padding: 10px 20px; border-radius: 12px; border: none; "
	                        + "cursor: pointer; color: white; font-weight: bold; transition: 0.3s ease-in-out; }"
	                        + ".edit-btn { background: linear-gradient(45deg, #4d50f1, #405ac2); }" /* Blue Edit Button */
	                        + ".delete-btn { background: linear-gradient(45deg, #ff4d4d, #d33c3c); }" /* Red Delete Button */
	                        + "button:hover { transform: scale(1.1); }"
	                        + "form { display: inline; }"
	                        + "</style></head><body>"
	                        + "<h2>Employee Details</h2>"
	                        + "<div id='table-container'>"
	                        + "<table>"
	                        + "<tr><th>ID</th><th>Name</th><th>Email</th><th>Age</th><th>Address</th><th>Password</th><th>Actions</th></tr>"
	                        + "<tr><td>" + id + "</td>"
	                        + "<td>" + name + "</td>"
	                        + "<td>" + email + "</td>"
	                        + "<td>" + age + "</td>"
	                        + "<td>" + address + "</td>"
	                        + "<td>" + pass + "</td>"
	                        + "<td>"
	                        + "<form action='UpdateEmployeeServlet' method='post'>"
	                        + "<input type='hidden' name='em' value='" + email + "'>"
	                        + "<button type='submit' class='edit-btn'>Edit</button>"
	                        + "</form> "
	                        + "<form action='DeleteEmployeeServletConfirm' method='post'>"
	                        + "<input type='hidden' name='em' value='" + email + "'>"
	                        + "<button type='submit' class='delete-btn'>Delete</button>"
	                        + "</form>"
	                        + "</td></tr>"
	                        + "</table>"
	                        + "</div>"
	                        + "</body></html>");



	            } else {
//	                pw.println("<html><body><div>");
//	                pw.println("<h1 style='color:red;'>Wrong email or password</h1>");
//	                pw.println("</div></body></html>");
	            	
	            	pw.println("<html><head><title>Login Error</title>"
	            	        + "<style>"
	            	        + "body { display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; "
	            	        + "background: linear-gradient(45deg, #4d50f1, #aeb5d2); font-family: Arial, sans-serif; }"
	            	        + "#error-container { background: radial-gradient(circle, #ff4b4b, #b93232); padding: 30px; border-radius: 20px; "
	            	        + "box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.5); text-align: center; width: 50%; color: white; }"
	            	        + "h1 { font-size: 28px; margin-bottom: 15px; }"
	            	        + "button { font-size: 18px; padding: 10px 20px; border-radius: 12px; border: none; "
	            	        + "background: linear-gradient(45deg, #4d50f1, #405ac2); cursor: pointer; color: white; font-weight: bold; }"
	            	        + "button:hover { transform: scale(1.1); transition: 0.3s ease-in-out; }"
	            	        + "</style></head><body>"
	            	        + "<div id='error-container'>"
	            	        + "<h1>Wrong email or password</h1>"
	            	        + "<form action='login.html'>"
	            	        + "<button type='submit'>Try Again</button>"
	            	        + "</form>"
	            	        + "</div>"
	            	        + "</body></html>");

//	                RequestDispatcher rd = req.getRequestDispatcher("login.html");
//	                rd.include(req, resp);
	            }     
	                
	                
	                
	                
	                
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
