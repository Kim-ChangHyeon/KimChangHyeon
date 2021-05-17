package com.wc.pb.log.vo;

import java.util.Date;

public class AccessLogVO {
	
	//접근 로그 번호
	private int aLog_no;
	//고객 번호
	private String customer_nick;
	//접근한 아이피
	private String aLog_ip;
	//접근한 곳
	private String aLog_link;
	//접근 일시
	private Date aLog_date;
	//카운트
	private int count;

	public AccessLogVO() {
		super();
	}

	
	
	public AccessLogVO(int aLog_no, String customer_nick, String aLog_ip, String aLog_link, Date aLog_date, int count) {
		super();
		this.aLog_no = aLog_no;
		this.customer_nick = customer_nick;
		this.aLog_ip = aLog_ip;
		this.aLog_link = aLog_link;
		this.aLog_date = aLog_date;
		this.count = count;
	}



	public int getaLog_no() {
		return aLog_no;
	}



	public void setaLog_no(int aLog_no) {
		this.aLog_no = aLog_no;
	}


	public String getaLog_ip() {
		return aLog_ip;
	}



	public void setaLog_ip(String aLog_ip) {
		this.aLog_ip = aLog_ip;
	}



	public String getaLog_link() {
		return aLog_link;
	}



	public void setaLog_link(String aLog_link) {
		this.aLog_link = aLog_link;
	}



	public Date getaLog_date() {
		return aLog_date;
	}



	public void setaLog_date(Date aLog_date) {
		this.aLog_date = aLog_date;
	}



	public String getcustomer_nick() {
		return customer_nick;
	}



	public void setcustomer_nick(String customer_nick) {
		this.customer_nick = customer_nick;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}







}
