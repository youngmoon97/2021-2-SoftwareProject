package recommend_menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuList {
	private Menu[] menulist;
	
	public MenuList() throws SQLException {		
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
		
		String sql="SELECT * FROM food";
		
	    try {
	    	PreparedStatement pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	        
	        ResultSet rs = pstmt.executeQuery();
	        
	        rs.last();
			int rnum=rs.getRow();
			rs.beforeFirst();
	        
	        //stt=new String[rnum];
			menulist=new Menu[rnum];
			int i=0;

	        while(rs.next()) {
	        	menulist[i]=new Menu(rs.getString(1), rs.getString(2),rs.getString(3));
	        	i++;
			}
	        pstmt.close();
	        rs.close();
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
	    finally {
	    	con.close();
	    }
	}
	public Menu[] getmenulist() {
		return this.menulist;
	}
	public void addmenulist(Menu menu) {
		
	}
	public void delmenulist(Menu menu) {
		
	}
}
