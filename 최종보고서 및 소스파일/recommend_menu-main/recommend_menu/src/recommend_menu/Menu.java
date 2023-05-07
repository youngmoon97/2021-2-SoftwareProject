package recommend_menu;

public class Menu {
	String maincategory;
	String subcategory;
	String name;
	
	public Menu(String name, String maincategory, String subcategory){
		this.maincategory=maincategory;
		this.subcategory=subcategory;
		this.name=name;
	}
	public String get_maincategory() {
		return this.maincategory;
	}
	public String get_subcategory() {
		return this.subcategory;
	}
	public String getname() {
		return this.name;
	}
}
