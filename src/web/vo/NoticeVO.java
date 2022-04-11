package web.vo;

public class NoticeVO {
	int no;
	String title;
	String content;
	
	public NoticeVO(int no, String title, String content) {
		setNo(no);
		setTitle(title);
		setContent(content);
	}

	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	
}
