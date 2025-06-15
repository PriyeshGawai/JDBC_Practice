package practice_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NonSelectSqlQuery {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection conn=null;
		Statement st=null;
		try {
			sc= new Scanner(System.in);
			System.out.println("Enter id:");
			int id=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter Sname");
			String name=sc.nextLine();
			
			System.out.println("Enter Location");
			String loc=sc.nextLine();
			
			System.out.println("Enter Average");
			float avg=sc.nextFloat();			
			
			sc.close();
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
			
			if(conn!=null)
				st= conn.createStatement();
			
			//String query="insert into student values(200, 'ramesh','pune',66.67)";
			
			String query="insert into student values("+id+", "+ "'"+name+"'" + ","+ "'"+loc+"'"+", "+avg+" )";
			int count=0;
			if(st!=null) {
//				showDetail(conn, st);
//				System.exit(0);
				count = st.executeUpdate(query);
			}
			
			if(count==0)System.out.println("Not insert");
			
			else System.out.println("Data insert into table");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(st!=null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn!=null) {
				try {
					conn.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
		
	}
	private static void showDetail(Connection conn,Statement st) throws SQLException {
		String query="select * from student";
		ResultSet rs=null;
			rs=st.executeQuery(query);
		
		if(rs==null)System.out.println("data not show!");
		
		else 
			while(rs.next()) {
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+ "  "+rs.getString(3)+"  "+rs.getFloat(4));
		}
	}

}
