package recommend_menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BoardSystem {
	private Post[] Postlist;
	private Post post;
	private Member mm;
	
	public BoardSystem(Member mm) {
		this.mm=mm;
	}
	
	public int writePost(Post post) throws SQLException {
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
		String sql="insert into POST values(a.nextval, ?, ?, ?, TO_CHAR(sysdate, 'YYYYMMDDHH24MISS'))";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, post.get_title());
			pstmt.setString(2, post.get_contents());
			pstmt.setString(3, post.get_writer());
			
			int num=pstmt.executeUpdate();
			
			pstmt.close();
			return num;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
		finally {
			con.close();
		}
	}
	public int delPost(Post post) throws SQLException {
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
		String sql="delete from POST where 게시물번호=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, post.get_postnum());
			
			int num=pstmt.executeUpdate();
			
			pstmt.close();
			return num;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
		finally {
			con.close();
		}
	}
	public int adjustPost(Post post) throws SQLException {
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
		String sql="update POST set 제목=?, 내용=?, 작성일시=TO_CHAR(sysdate, 'YYYYMMDDHH24MISS') where 게시물번호=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, post.get_title());
			pstmt.setString(2, post.get_contents());
			pstmt.setInt(3, post.get_postnum());
			
			int num=pstmt.executeUpdate();
			
			pstmt.close();
			return num;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
		finally {
			con.close();
		}
	}
	public Post[] searchPost(String str, String str2) throws SQLException {
		Post[] pp = null;
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
		String query = "select * from POST where "+str+" like '"+str2+"' order by 작성일시 desc";
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = stmt.executeQuery(query);
			
			rs.last();
			int rnum=rs.getRow();
			rs.beforeFirst();
			
			pp=new Post[rnum];
			int i=0;
			
			while(rs.next()) {
				String num=rs.getString(1);
				String title=rs.getString(2);
				String contents=rs.getString(3);
				String writer=rs.getString(4);
				String writetime=rs.getString(5);
				
				pp[i]=new Post(Integer.parseInt(num), title, contents, writer, writetime);
				i++;
			}
			stmt.close();
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
		
		return pp;
	}
	public Postlist updatePostlist() throws SQLException {
		Postlist pl=new Postlist();
		
		return pl;
	}
}
