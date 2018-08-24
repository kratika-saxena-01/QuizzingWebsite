import java.sql.*;

public class UserDAO {

	private String dbURL;
	private String dbUsername;
	private String dbPass;
	
	Connection con=null;
	
	public UserDAO(String dbURL, String dbUsername, String dbPass) {
		super();
		this.dbURL = dbURL;
		this.dbUsername = dbUsername;
		this.dbPass = dbPass;
	}
	
	void connect() throws ClassNotFoundException, SQLException 
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
	
	boolean RegisterUser(Users u) throws SQLException, ClassNotFoundException
	{
		connect();
		PreparedStatement ps=con.prepareStatement("insert into users(name,email,pass) values (?,?,?)");
		ps.setString(1,u.getName());
		ps.setString(2,u.getEmail());
		ps.setString(3,u.getPass());
		boolean res=ps.executeUpdate()>0;
		ps.close();
		con.close();
		return res;
	}
	
	boolean getUser(String email,String pass ) throws ClassNotFoundException, SQLException
	{
		connect();
		PreparedStatement ps=con.prepareStatement("select * from users where email=? and pass=?");
		ps.setString(1, email);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
			return true;
		ps.close();
		con.close();
		rs.close();
		return false;
		
	}
	
}
