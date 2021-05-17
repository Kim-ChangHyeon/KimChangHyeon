package com.wc.pb.customer.vo;

import java.util.Date;

public class CustomerLogVO {
	
	
	//고객 로그 번호
	private int clog_no;
	//고객 번호
	private int customer_no;
	//관리자 번호
	private int admin_no;
	//변경 전 등급
	private int ex_grade;
	//변경 후 등급
	private int af_grade;
	//로그 설명
	private String clog_description;
	//변경 전 비밀번호
	private String ex_password;
	//변경 후 비밀번호
	private String af_password;
	//변경 전 닉네임
	private String ex_nick;
	//변경 후 닉네임
	private String af_nick;
	//변경 후 닉네임
	private String clog_ip;
	//로그 일시
	private Date clog_date;
	
	
	public CustomerLogVO() {
		super();
	}
	
	


	public CustomerLogVO(int clog_no, int customer_no, int admin_no, int ex_grade, int af_grade,
			String clog_description, String ex_password, String af_password, String ex_nick, String af_nick,
			Date clog_date) {
		super();
		this.clog_no = clog_no;
		this.customer_no = customer_no;
		this.admin_no = admin_no;
		this.ex_grade = ex_grade;
		this.af_grade = af_grade;
		this.clog_description = clog_description;
		this.ex_password = ex_password;
		this.af_password = af_password;
		this.ex_nick = ex_nick;
		this.af_nick = af_nick;
		this.clog_ip = clog_ip;
		this.clog_date = clog_date;
	}




	public int getClog_no() {
		return clog_no;
	}




	public void setClog_no(int clog_no) {
		this.clog_no = clog_no;
	}




	public int getCustomer_no() {
		return customer_no;
	}




	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}




	public int getAdmin_no() {
		return admin_no;
	}




	public void setAdmin_no(int admin_no) {
		this.admin_no = admin_no;
	}




	public int getEx_grade() {
		return ex_grade;
	}




	public void setEx_grade(int ex_grade) {
		this.ex_grade = ex_grade;
	}




	public int getAf_grade() {
		return af_grade;
	}




	public void setAf_grade(int af_grade) {
		this.af_grade = af_grade;
	}




	public String getClog_description() {
		return clog_description;
	}




	public void setClog_description(String clog_description) {
		this.clog_description = clog_description;
	}




	public String getEx_password() {
		return ex_password;
	}




	public void setEx_password(String ex_password) {
		this.ex_password = ex_password;
	}




	public String getAf_password() {
		return af_password;
	}




	public void setAf_password(String af_password) {
		this.af_password = af_password;
	}




	public String getEx_nick() {
		return ex_nick;
	}




	public void setEx_nick(String ex_nick) {
		this.ex_nick = ex_nick;
	}




	public String getAf_nick() {
		return af_nick;
	}




	public void setAf_nick(String af_nick) {
		this.af_nick = af_nick;
	}




	public Date getClog_date() {
		return clog_date;
	}




	public void setClog_date(Date clog_date) {
		this.clog_date = clog_date;
	}




	public String getClog_ip() {
		return clog_ip;
	}




	public void setClog_ip(String clog_ip) {
		this.clog_ip = clog_ip;
	}


	
	
}
