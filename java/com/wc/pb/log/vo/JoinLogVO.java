package com.wc.pb.log.vo;

import java.util.Date;

public class JoinLogVO {
	//회원가입 로그 번호
	private int jLog_no;
	//회원가입한 고객 번호
	private int customer_no;
	//회원가입한 아이피
	private String jlog_ip;
	//회원가입 일시
	private Date jlog_dateTime;
	
	public JoinLogVO() {
		super();
	}
	public JoinLogVO(int jLog_no, int customer_no, String jlog_ip, Date jlog_dateTime) {
		super();
		this.jLog_no = jLog_no;
		this.customer_no = customer_no;
		this.jlog_ip = jlog_ip;
		this.jlog_dateTime = jlog_dateTime;
	}
	public int getjLog_no() {
		return jLog_no;
	}
	public void setjLog_no(int jLog_no) {
		this.jLog_no = jLog_no;
	}
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	public String getJlog_ip() {
		return jlog_ip;
	}
	public void setJlog_ip(String jlog_ip) {
		this.jlog_ip = jlog_ip;
	}
	public Date getJlog_dateTime() {
		return jlog_dateTime;
	}
	public void setJlog_dateTime(Date jlog_dateTime) {
		this.jlog_dateTime = jlog_dateTime;
	}
	
}
