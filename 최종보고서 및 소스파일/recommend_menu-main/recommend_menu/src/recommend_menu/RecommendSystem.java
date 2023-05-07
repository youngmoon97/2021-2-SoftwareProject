package recommend_menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class RecommendSystem {
	private Menu[] menulist;
	private Menu menu;
	String[] mainval = null;
	String[] midval = null;
	public RecommendSystem() {
		
	}
	
	
	public String recommend(String main, String mid) throws SQLException{
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "BOARD";
		String password = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver OK.");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver failed.");
		}
		
		try {
			con = DriverManager.getConnection(url, id, password);
			System.out.println("Connection OK.");
		}
		catch(SQLException e) {
			System.out.println("Connection failed.");
		}
		String sql=null;
		String sql1="SELECT * FROM (SELECT * FROM food ORDER BY dbms_random.value)"
				+ "WHERE rownum=1";
		String sql2="SELECT * FROM (SELECT * FROM food ORDER BY dbms_random.value)"
				+ "WHERE maincategory=? and rownum=1";
		String sql3="SELECT * FROM (SELECT * FROM food ORDER BY dbms_random.value)"
				+ "WHERE maincategory=? and middlecategory=? and rownum=1";
		if(main.equals("") && mid.equals("")) {
			sql=sql1;
		}
		else if(mid.equals("") && !main.equals("")) {
			sql=sql2;
		}
		else sql=sql3;
		
		String val=null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			if(sql.equals(sql1)) {
				
			}
			else if(sql.equals(sql2)) {
				pstmt.setString(1, main);
			}
			else {
				pstmt.setString(1, main);
				pstmt.setString(2, mid);
			}
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) val=rs.getString(1);
			pstmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
		return val;
	}
}