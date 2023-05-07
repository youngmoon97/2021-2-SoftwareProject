package recommend_menu;

public class Member {
	String ID;
	String PW;
	String name;
	String email;
	
	public Member(String ID, String PW, String name, String email) {
		this.ID=ID;
		this.PW=PW;
		this.name=name;
		this.email=email;
	}
	
	public String getID() {
		return this.ID;
	}
	public String getPW() {
		return this.PW;
	}
	public String getname() {
		return this.name;
	}
	public String getemail() {
		return this.email;
	}
}
