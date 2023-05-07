package recommend_menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;

public class MenuSearchSystem {
	Menu[] Menulist;
	
	public MenuSearchSystem() throws SQLException {
		MenuList Mlist=new MenuList();
		this.Menulist=Mlist.getmenulist();
	}
	
	public Menu[] SearchMenu(String a, String b) throws SQLException {
		Menu[] menus=null;
		int mnum=0;
		int snum=0;
		
		if(a.equals("")&&b.equals("")) {
			menus=Menulist;
		}
		else if(!a.equals("")&&b.equals("")) {
			for(int i=0; i<Menulist.length;i++) {
				if(Menulist[i].get_maincategory().equals(a)) {
					mnum++;
				}
			}
			menus=new Menu[mnum];
			int k=0;
			for(int i=0; i<Menulist.length;i++) {
				if(Menulist[i].get_maincategory().equals(a)) {
					menus[k]=Menulist[i];
					k++;
				}
			}
		}
		else {
			for(int i=0;i<Menulist.length; i++) {
				if(Menulist[i].get_maincategory().equals(a)&&Menulist[i].get_subcategory().equals(b)) {
					mnum++;
				}
			}
			menus=new Menu[mnum];
			int k=0;
			for(int i=0; i<Menulist.length;i++) {
				if(Menulist[i].get_maincategory().equals(a)&&Menulist[i].get_subcategory().equals(b)) {
					menus[k]=Menulist[i];
					k++;
				}
			}
		}
		
		
		return menus;
	}
}
