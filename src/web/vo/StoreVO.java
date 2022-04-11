package web.vo;

public class StoreVO {
	private String stname, sttype, fulljibun;

	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public String getSttype() {
		return sttype;
	}

	public void setSttype(String sttype) {
		this.sttype = sttype;
	}

	public String getFulljibun() {
		return fulljibun;
	}

	public void setFulljibun(String fulljibun) {
		this.fulljibun = fulljibun;
	}

	public StoreVO(String stname, String sttype, String fulljibun) {
		setStname(stname);
		setSttype(sttype);
		setFulljibun(fulljibun);
	}
}
