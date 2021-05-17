package com.wc.pb.customer.vo;

import java.util.Date;

public class CustomerVO {

	//고객 번호
	private int customer_no;
	//고객 이메일
	private String customer_email;
	//고객 닉네임
	private String customer_nick;
	//고객 비밀번호
	private String customer_password;
	//고객 전화번호
	private String customer_phone;
	//고객 등급
	private int customer_grade;
	//고객 가입일
	private Date customer_joinDate;
	//마케팅동의
	private char marketing_agree;
	
	public CustomerVO() {
		super();
	}

	public CustomerVO(int customer_no, String customer_email, String customer_nick, String customer_password,
			String customer_phone, int customer_grade, Date customer_joinDate, char marketing_agree) {
		super();
		this.customer_no = customer_no;
		this.customer_email = customer_email;
		this.customer_nick = customer_nick;
		this.customer_password = customer_password;
		this.customer_phone = customer_phone;
		this.customer_grade = customer_grade;
		this.customer_joinDate = customer_joinDate;
		this.marketing_agree = marketing_agree;
	}

	public int getCustomer_no() {
		return customer_no;
	}

	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_nick() {
		return customer_nick;
	}

	public void setCustomer_nick(String customer_nick) {
		this.customer_nick = customer_nick;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public String getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}

	public int getCustomer_grade() {
		return customer_grade;
	}

	public void setCustomer_grade(int customer_grade) {
		this.customer_grade = customer_grade;
	}

	public Date getCustomer_joinDate() {
		return customer_joinDate;
	}

	public void setCustomer_joinDate(Date customer_joinDate) {
		this.customer_joinDate = customer_joinDate;
	}

	public char getMarketing_agree() {
		return marketing_agree;
	}

	public void setMarketing_agree(char marketing_agree) {
		this.marketing_agree = marketing_agree;
	}
	
	
	
}
