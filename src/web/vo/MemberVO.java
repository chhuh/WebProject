package web.vo;

public class MemberVO {
	private int no;
	private String name, email, pw, userType, fl;

	
	
	public MemberVO(int no, String name, String email, String pw, String fl) {
		super();
		this.no = no;
		this.name = name;
		this.email = email;
		this.pw = pw;
		this.fl = fl;
	}

	public MemberVO(String email, String pw) {
		setEmail(email);
		setPw(pw);
	}

	
	public String getFl() {
		return fl;
	}

	public void setFl(String fl) {
		this.fl = fl;
	}

	public MemberVO() {
		
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", name=" + name + ", email=" + email + ", pw=" + pw + ", userType=" + userType
				+ ", fl=" + fl + "]";
	}

	
	
}
