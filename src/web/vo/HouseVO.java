package web.vo;

public class HouseVO {
	private int no;
	private String dealAmount;
	private String aptName;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public HouseVO(int no, String aptName, String dealAmount) {
		super();
		this.no = no;
		this.dealAmount = dealAmount;
		this.aptName = aptName;
	}
	
	
}
