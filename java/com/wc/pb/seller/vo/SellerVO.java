package com.wc.pb.seller.vo;

public class SellerVO {
	// 판매 번호
	private int seller_no;
	// 구매자 번호
	private int customer_no;
	// 판매자 지역
	private String seller_location;
	// 판매자 전공 
	private String seller_major;
	// 판매자 정보
	private String seller_info;
	// 판매자 수입 
	private int seller_income;
	
	public SellerVO() {
		super();
	}

	public SellerVO(int seller_no, int customer_no, String seller_location, String seller_major, String seller_info,
			int seller_income) {
		super();
		this.seller_no = seller_no;
		this.customer_no = customer_no;
		this.seller_location = seller_location;
		this.seller_major = seller_major;
		this.seller_info = seller_info;
		this.seller_income = seller_income;
	}

	public int getSeller_no() {
		return seller_no;
	}

	public void setSeller_no(int seller_no) {
		this.seller_no = seller_no;
	}

	public int getCustomer_no() {
		return customer_no;
	}

	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}

	public String getSeller_location() {
		return seller_location;
	}

	public void setSeller_location(String seller_location) {
		this.seller_location = seller_location;
	}

	public String getSeller_major() {
		return seller_major;
	}

	public void setSeller_major(String seller_major) {
		this.seller_major = seller_major;
	}

	public String getSeller_info() {
		return seller_info;
	}

	public void setSeller_info(String seller_info) {
		this.seller_info = seller_info;
	}

	public int getSeller_income() {
		return seller_income;
	}

	public void setSeller_income(int seller_income) {
		this.seller_income = seller_income;
	}

	
	
}
