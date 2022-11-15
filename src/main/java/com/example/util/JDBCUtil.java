package example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	public static Connection getConnection(){
	    Connection con=null;
	    try{
	        Class.forName("com.mysql.jdbc.Driver");
	        con= DriverManager.getConnection("jdbc:mysql://walab.handong.edu.net:3306/p2_22000631","p2_22000631","EeKoh6ue3o");
	    }catch(Exception e){
	    	System.out.println(e);
	    }
	    return con;
	}

	public static void main(String ars[]) {
		Connection conn = getConnection();
		if(conn != null)
			System.out.println("DB 연결됨!");
		else
			System.out.println("DB 연결중 오류 !");
	}
}