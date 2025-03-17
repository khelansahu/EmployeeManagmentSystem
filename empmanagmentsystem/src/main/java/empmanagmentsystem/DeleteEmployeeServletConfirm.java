package empmanagmentsystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteEmployeeServletConfirm extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter pw=resp.getWriter();
	HttpSession session=req.getSession();
	String email=(String)session.getAttribute("email");
	String pass=(String)session.getAttribute("pass");
	
//	pw.println("<html><body><form action='DeleteEmployeeServlet' method='post' style='display:inline;'>"
//            + "<button>Delete</button>"
//            + "</form>"
//            +"<form action='login' method='post' style='display:inline;'>"
//			+ "<input type='hidden' name='em' value='" +email + "'>"
//			+ "<input type='hidden' name='pwd' value='" +pass + "'>"
//            + "<button>cancel</button>"
//            + "</form></body></html>");
	
	
//	kheln generated code....
	
//	 pw.println("<html><head><title>Confirm Deletion</title>");
//     pw.println("<style>"
//             + "body { display: flex; justify-content: center; align-items: center; height: 100vh; "
//             + "background: linear-gradient(45deg, #4d50f1, #aeb5d2); }"
//             + "#container { background: radial-gradient(circle, #5f8fff, #4b66be); padding: 30px; border-radius: 20px; "
//             + "box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.5); text-align: center; width: 50%; }"
//             + "h2 { color: red; font-size: 24px; }"
//             + "button { font-size: 20px; padding: 10px 30px; border-radius: 20px; background: linear-gradient(45deg, #4d50f1, #405ac2); "
//             + "border: none; cursor: pointer; color: white; margin: 10px; }"
//             + "form { display: inline; }"
//             + "</style>");
//     pw.println("</head><body>");
//     pw.println("<div id='container'>");
//     pw.println("<h2>Are you sure you want to delete this employee?</h2>");
//     pw.println("<form action='DeleteEmployeeServlet' method='post'>"
//             + "<button>Delete</button>"
//             + "</form>");
//     pw.println("<form action='login' method='post'>"
//             + "<input type='hidden' name='em' value='" + email + "'>"
//             + "<input type='hidden' name='pwd' value='" + pass + "'>"
//             + "<button>Cancel</button>"
//             + "</form>");
//     pw.println("</div>");
//     pw.println("</body></html>");
	
	
//	inhancing the ui using chatGpt
	
	pw.println("<html><head><title>Confirm Deletion</title>"
	        + "<style>"
	        + "body { display: flex; justify-content: center; align-items: center; height: 100vh; "
	        + "background: linear-gradient(45deg, #4d50f1, #aeb5d2); margin: 0; }"
	        + "#container { background: radial-gradient(circle, #5f8fff, #4b66be); padding: 30px; border-radius: 20px; "
	        + "box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.5); text-align: center; width: 40%; }"
	        + "h2 { color: white; font-size: 24px; margin-bottom: 20px; }"
	        + "button { font-size: 20px; padding: 12px 30px; border-radius: 20px; background: linear-gradient(45deg, #4d50f1, #405ac2); "
	        + "border: none; cursor: pointer; color: white; font-weight: bold; margin: 10px; box-shadow: 5px 5px 15px rgba(0, 0, 0, 0.5); }"
	        + "button:hover { transform: scale(1.1); transition: 0.3s ease-in-out; }"
	        + "form { display: inline; }"
	        + "</style></head><body>"
	        + "<div id='container'>"
	        + "<h2>Are you sure you want to delete this employee?</h2>"
	        + "<form action='DeleteEmployeeServlet' method='post'>"
	        + "<button>Delete</button>"
	        + "</form>"
	        + "<form action='login' method='post'>"
	        + "<input type='hidden' name='em' value='" + email + "'>"
	        + "<input type='hidden' name='pwd' value='" + pass + "'>"
	        + "<button>Cancel</button>"
	        + "</form>"
	        + "</div></body></html>");

}
}
