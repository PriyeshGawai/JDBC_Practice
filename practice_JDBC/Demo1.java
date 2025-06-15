package practice_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

class Demo2 {

	static {
		System.out.println("Static block of Demo2 Class");
	}

	public Demo2() {

		System.out.println("Constructor of Demo2");
	}
}

public class Demo1 {

	public static void main(String[] args) throws Exception {
		System.out.println("Demo ");
		//Demo2 d=new Demo2();
		Class.forName("practice_JDBC.Demo2");
		Class.forName("practice_JDBC.Demo2");
		
	
	}

}
