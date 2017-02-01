package blog.service;

public class BlogDTO {

	private String title;
	private String body;
	
	public BlogDTO() {
		
	}
	
	public BlogDTO(String t, String b) {
		this.title = t;
		this.body = b;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
}
