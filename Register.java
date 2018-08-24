

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
     UserDAO userdao; 
  
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init() {
		String dbURL=getServletContext().getInitParameter("dbURL");
		String dbUsername=getServletContext().getInitParameter("dbUsername");
		String dbPass=getServletContext().getInitParameter("dbPass");
		userdao=new UserDAO(dbURL,dbUsername,dbPass);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		Users u=new Users(name,email,pass);
		try {
			if(userdao.RegisterUser(u))
			{
				RequestDispatcher dis=request.getRequestDispatcher("Login.jsp");
				dis.forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
