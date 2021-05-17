package com.wc.pb.customer.vo;

import java.util.Date;

public class SellerAuthVO {
	// 판매자 인증 번호
	private int seller_auth_no;
	// 사용자 번호
	private int customer_no;
	//	승인여부
	private char seller_authCheck;
	// 판매자 신청 날짜
	private Date seller_applyDateTime;
	// 판매자 전환 날짜
	private Date seller_authCheckDate;
	
	public SellerAuthVO() {
		super();
	}

	public SellerAuthVO(int seller_auth_no, int customer_no, char seller_authCheck, Date seller_applyDateTime,
			Date seller_authCheckDate) {
		super();
		this.seller_auth_no = seller_auth_no;
		this.customer_no = customer_no;
		this.seller_authCheck = seller_authCheck;
		this.seller_applyDateTime = seller_applyDateTime;
		this.seller_authCheckDate = seller_authCheckDate;
	}

	public int getSeller_auth_no() {
		return seller_auth_no;
	}

	public void setSeller_auth_no(int seller_auth_no) {
		this.seller_auth_no = seller_auth_no;
	}

	public int getCustomer_no() {
		return customer_no;
	}

	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}

	public char getSeller_authCheck() {
		return seller_authCheck;
	}

	public void setSeller_authCheck(char seller_authCheck) {
		this.seller_authCheck = seller_authCheck;
	}

	public Date getSeller_applyDateTime() {
		return seller_applyDateTime;
	}

	public void setSeller_applyDateTime(Date seller_applyDateTime) {
		this.seller_applyDateTime = seller_applyDateTime;
	}

	public Date getSeller_authCheckDate() {
		return seller_authCheckDate;
	}

	public void setSeller_authCheckDate(Date seller_authCheckDate) {
		this.seller_authCheckDate = seller_authCheckDate;
	}

	
}
