package recommend_menu;

public class Post {
	private int postnum;
	private String title;
	private String contents;
	private String writer;
	private String writetime;
	
	public Post(int postnum, String title, String contents, String writer, String writetime) {
		this.postnum=postnum;
		this.title=title;
		this.contents=contents;
		this.writer=writer;
		this.writetime=writetime;
	}
	
	public int get_postnum() {
		return this.postnum;
	}
	public String get_title() {
		return this.title;
	}
	public void set_title(String title) {
		this.title=title;
	}
	public String get_contents() {
		return this.contents;
	}
	public void set_contents(String contents) {
		this.contents=contents;
	}
	public String get_writer() {
		return this.writer;
	}
	public String get_writetime() {
		return this.writetime;
	}
	public void set_writetime(String writetime) {
		this.writetime=writetime;
	}
	public void writepost() {
		
	}
}
