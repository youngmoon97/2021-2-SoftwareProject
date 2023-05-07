package recommend_menu;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;
import java.sql.PreparedStatement;

public class Postlist {
	private Post[] Postlist;
	
	public Postlist() throws SQLException {
		
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
		
		String query = "select * from POST order by 작성일시 desc";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.last();
			int rnum=rs.getRow();
			rs.beforeFirst();
			
			Postlist=new Post[rnum];
			int i=0;
			
			while(rs.next()) {
				String num=rs.getString(1);
				String title=rs.getString(2);
				String contents=rs.getString(3);
				String writer=rs.getString(4);
				String writetime=rs.getString(5);
				
				Postlist[i]=new Post(Integer.parseInt(num), title, contents, writer, writetime);
				i++;
			}
			pstmt.close();
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
	}
	
	public void add_post(Post post) {
		
	}
	public void del_post(Post post) {
		
	}
	public Post[] get_postlist() {
		return this.Postlist;
	}
	
	
	
	public static void main(String[] args) throws SQLException {
		Postlist PP=new Postlist();
	}
	
}
