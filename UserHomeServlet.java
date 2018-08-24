

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserHomeServlet
 */
@WebServlet("/UserHomeServlet")
public class UserHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Quiz q=new Quiz();
	QuizDAO dao;
	int quiz_no=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init()
    {
    	String jdbcURL=getServletContext().getInitParameter("dbURL");
    	String jdbcUserName=getServletContext().getInitParameter("dbUsername");
    	String jdbcPassword=getServletContext().getInitParameter("dbPass");
    	dao= new QuizDAO(jdbcURL,jdbcUserName,jdbcPassword);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action=request.getServletPath();
		
		try
		{
			
		switch(action)
		{
		case "/java":
			q.setTopic("java");
			quizCall(request,response);
			break;
		case "/c":
			q.setTopic("c");
			quizCall(request,response);
			break;
		case "/c++":
			q.setTopic("c++");
			quizCall(request,response);
			break;
		case "/pyhton":
			q.setTopic("python");
			quizCall(request,response);
			break;
		case "/css":
			q.setTopic("css");
			quizCall(request,response);
			break;
		case "/html":
			q.setTopic("html");
			quizCall(request,response);
			break;
		case "/php":
			q.setTopic("php");
			quizCall(request,response);
			break;
		case "/sql":
			q.setTopic("sql");
			quizCall(request,response);
			break;
		case "/javascript":
			q.setTopic("js");
			quizCall(request,response);
			break;
		default:
			System.out.println("wrong choice");
		}
		}
		catch(SQLException e)
		{
			throw new ServletException(e);
		}
	}
		
		private void quizCall(HttpServletRequest request,HttpServletResponse response)
				throws SQLException,IOException,ServletException
		{
			
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("QuizNumber.jsp");
			dispatcher.forward(request, response);
			String act=request.getServletPath();
			switch(act)
			{
			case "/one":
				quiz_no = 1;
				break;
			case "/two":
				quiz_no=2;
				break;
			case "/three":
				quiz_no=3;
				break;
			case "/four":
				quiz_no=4;
				break;
				
			}
			
			List<Quiz> list=dao.completeQuiz(q.getTopic(),quiz_no);
			request.setAttribute("quiz", list);
			RequestDispatcher disp=request.getRequestDispatcher("TakeQuiz.jsp");
			disp.forward(request, response);
		
	}
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
