package com.wc.pb.admin.vo;

import java.util.Date;

public class EmailAuthVO {
	
	
	//이메일 승인 번호
	private int email_auth_no;
	//고객 번호
	private int customer_no;
	//승인여부
	private char email_auth_check;
	//승인 일시
	private Date email_auth_date;
	public EmailAuthVO() {
		super();
	}
	public EmailAuthVO(int email_auth_no, int customer_no, char email_auth_check, Date email_auth_date) {
		super();
		this.email_auth_no = email_auth_no;
		this.customer_no = customer_no;
		this.email_auth_check = email_auth_check;
		this.email_auth_date = email_auth_date;
	}
	public int getEmail_auth_no() {
		return email_auth_no;
	}
	public void setEmail_auth_no(int email_auth_no) {
		this.email_auth_no = email_auth_no;
	}
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	public char getEmail_auth_check() {
		return email_auth_check;
	}
	public void setEmail_auth_check(char email_auth_check) {
		this.email_auth_check = email_auth_check;
	}
	public Date getEmail_auth_date() {
		return email_auth_date;
	}
	public void setEmail_auth_date(Date email_auth_date) {
		this.email_auth_date = email_auth_date;
	}
	
	

	
}
