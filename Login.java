

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 UserDAO userdao;
	  
    
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
     
    public void init()
    {
    	String dbURL=getServletContext().getInitParameter("dbURL");
    	String dbUsername=getServletContext().getInitParameter("dbUsername");
    	String dbPass=getServletContext().getInitParameter("dbPass");
    	userdao=new UserDAO(dbURL,dbUsername,dbPass);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		try {
			if(userdao.getUser(email,pass))
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("UserHome.jsp");
				dispatcher.include(request, response);
			}
			else
			{
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.println("<script type=\"text/javascript\">\r\n" + 
						"        	alert(\"Wrong username or password\");\r\n" + 
						"        </script>    ");
				RequestDispatcher dis=request.getRequestDispatcher("Login.jsp");
				dis.include(request, response);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
