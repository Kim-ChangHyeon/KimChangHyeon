package com.wc.pb.log.vo;

import java.util.Date;

public class SellerLogVO {
	// 판매자 정보 변경 로그 번호
	private int slog_no;
	// 판매자 번호
	private int seller_no;
	// 변경 전 지역
	private String ex_location;
	// 변경 후 지역
	private String af_location;
	// 변경 전 전공
	private String ex_major;
	// 변경 후 전공
	private String af_major;
	// 변경 전 정보
	private String ex_info;
	// 변경 후 정보
	private String af_info;
	// 변경 전 포트폴리오
	private String ex_portfolio;
	// 변경 후 포트폴리오
	private String af_portfolio;
	// 변경 로그 IP
	private String slog_ip;
	// 변경 로그 날짜
	private Date slog_date;
	
	public SellerLogVO() {
		super();
	}
	public SellerLogVO(int slog_no, int seller_no, String ex_location, String af_location, String ex_major,
			String af_major, String ex_info, String af_info, String ex_portfolio, String af_portfolio, Date slog_date, String slog_ip) {
		super();
		this.slog_no = slog_no;
		this.seller_no = seller_no;
		this.ex_location = ex_location;
		this.af_location = af_location;
		this.ex_major = ex_major;
		this.af_major = af_major;
		this.ex_info = ex_info;
		this.af_info = af_info;
		this.ex_portfolio = ex_portfolio;
		this.af_portfolio = af_portfolio;
		this.slog_ip = slog_ip;
		this.slog_date = slog_date;
	}
	public int getSlog_no() {
		return slog_no;
	}
	public void setSlog_no(int slog_no) {
		this.slog_no = slog_no;
	}
	public int getSeller_no() {
		return seller_no;
	}
	public void setSeller_no(int seller_no) {
		this.seller_no = seller_no;
	}
	public String getEx_location() {
		return ex_location;
	}
	public void setEx_location(String ex_location) {
		this.ex_location = ex_location;
	}
	public String getAf_location() {
		return af_location;
	}
	public void setAf_location(String af_location) {
		this.af_location = af_location;
	}
	public String getEx_major() {
		return ex_major;
	}
	public void setEx_major(String ex_major) {
		this.ex_major = ex_major;
	}
	public String getAf_major() {
		return af_major;
	}
	public void setAf_major(String af_major) {
		this.af_major = af_major;
	}
	public String getEx_info() {
		return ex_info;
	}
	public void setEx_info(String ex_info) {
		this.ex_info = ex_info;
	}
	public String getAf_info() {
		return af_info;
	}
	public void setAf_info(String af_info) {
		this.af_info = af_info;
	}
	public String getEx_portfolio() {
		return ex_portfolio;
	}
	public void setEx_portfolio(String ex_portfolio) {
		this.ex_portfolio = ex_portfolio;
	}
	public String getAf_portfolio() {
		return af_portfolio;
	}
	public void setAf_portfolio(String af_portfolio) {
		this.af_portfolio = af_portfolio;
	}
	public Date getSlog_date() {
		return slog_date;
	}
	public void setSlog_date(Date slog_date) {
		this.slog_date = slog_date;
	}
	public String getSlog_ip() {
		return slog_ip;
	}
	public void setSlog_ip(String slog_ip) {
		this.slog_ip = slog_ip;
	}
	
	
}
