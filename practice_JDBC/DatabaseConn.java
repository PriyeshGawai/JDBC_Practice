package practice_JDBC;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConn {


	public static void main(String[] args)  {
		
		ResultSet rs=null;
		Statement st=null;
		
		try {
			
//			Load jdbc Driver class(optional)
			Class.forName("com.mysql.cj.jdbc.Driver");
		
//			Establish the connection
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root","root");
		
//		Create jdbc Statment object
		st=conn.createStatement();
		
//		Create sql query
		String query="Select * from student";
		
//		Execute query
		 rs=st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+ "  "+rs.getString(3)+"  "+rs.getFloat(4));
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}

