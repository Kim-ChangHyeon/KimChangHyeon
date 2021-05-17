package com.wc.pb.log.vo;

import java.util.Date;

public class LoginLogVO {
	//로그인 로그 번호
	private int loginLog_no;
	//고객 번호
	private int customer_no;
	//로그인 성공 or 실패
	private char loginLog_success;
	//로그인 했을 때 적은 아이디
	private String loginLog_customerId;
	//로그인 했을때 일시
	private Date loginLog_dateTime;
	//실패 이유 ex/비밀번호 불일치, 아이디 불일치
	private String loginLog_reason;
	//로그인 시도 아이피
	private String loginLog_ip;
	public LoginLogVO(int loginLog_no, int customer_no, char loginLog_success, String loginLog_customerId,
			Date loginLog_dateTime, String loginLog_reason, String loginLog_ip) {
		super();
		this.loginLog_no = loginLog_no;
		this.customer_no = customer_no;
		this.loginLog_ip = loginLog_ip;
		this.loginLog_success = loginLog_success;
		this.loginLog_customerId = loginLog_customerId;
		this.loginLog_dateTime = loginLog_dateTime;
		this.loginLog_reason = loginLog_reason;
	}
	public LoginLogVO() {
		super();
	}
	public int getLoginLog_no() {
		return loginLog_no;
	}
	public void setLoginLog_no(int loginLog_no) {
		this.loginLog_no = loginLog_no;
	}
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	public char getLoginLog_success() {
		return loginLog_success;
	}
	public void setLoginLog_success(char loginLog_success) {
		this.loginLog_success = loginLog_success;
	}
	public String getLoginLog_customerId() {
		return loginLog_customerId;
	}
	public void setLoginLog_customerId(String loginLog_customerId) {
		this.loginLog_customerId = loginLog_customerId;
	}
	public Date getLoginLog_dateTime() {
		return loginLog_dateTime;
	}
	public void setLoginLog_dateTime(Date loginLog_dateTime) {
		this.loginLog_dateTime = loginLog_dateTime;
	}
	public String getLoginLog_reason() {
		return loginLog_reason;
	}
	public void setLoginLog_reason(String loginLog_reason) {
		this.loginLog_reason = loginLog_reason;
	}
	public String getLoginLog_ip() {
		return loginLog_ip;
	}
	public void setLoginLog_ip(String loginLog_ip) {
		this.loginLog_ip = loginLog_ip;
	}
	
}
