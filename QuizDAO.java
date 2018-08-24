import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuizDAO {

	private String dbURL;
	private String dbUsername;
	private String dbPass;	
	Connection con=null;
	
	public QuizDAO() {}
	
	QuizDAO(String dbURL,String dbUsername,String dbPass)
	{
		this.dbURL=dbURL;
		this.dbUsername=dbUsername;
		this.dbPass=dbPass;
		
	}
   void connect() throws SQLException
   {
        if(con == null|| con.isClosed()) 
        {
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } 
            catch(ClassNotFoundException e) 
            {
                throw new SQLException(e);
            }
            
            con = DriverManager.getConnection(dbURL, dbUsername,dbPass);
        }
   }
     
   void disconnect() throws SQLException 
   {
       if(con != null  && !con.isClosed()) 
           con.close();
   }
   
   public List<Quiz> completeQuiz(String topic1,int quiz_no1) throws SQLException
   {
	   List<Quiz> l=new ArrayList<>();
	   connect();
	   Statement stmt=con.createStatement();
	   ResultSet rs=stmt.executeQuery("select * from questions where topic='topic1' and quiz_no=quiz_no1");
	   while(rs.next())
	   {
		   int question_no=rs.getInt("question_no");
		   String st=rs.getString("question_stmt");
		   String opt1=rs.getString("option1");
		   String opt2=rs.getString("option2");
		   String opt3=rs.getString("option3");
		   String opt4=rs.getString("option4");
		   String corr=rs.getString("correct");
		   Quiz q=new Quiz(topic1,quiz_no1,question_no,st,opt1,opt2,opt3,opt4,corr);
		   l.add(q);
	   }
	   rs.close();
	   stmt.close();
	   disconnect();
	   return l;
   }
	
}
