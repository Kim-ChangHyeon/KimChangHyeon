package com.wc.pb.admin.vo;

import java.sql.Date;

public class InquiryToAdminVO {

	//관리자 문의 번호
	private int inquiry_no;
	//관리자 문의 글쓴 멤버 번호
	private int customer_no;
	//글쓴이
	private String writer_nick;
	//문의 답변 타겟
	private int inquiry_parent;
	//문의 제목
	private String inquiry_title;
	//문의 내용
	private String inquiry_content;
	//문의 일시
	private Date inquiry_date;
	//답변 상태
	private char inquiry_status;
	//회신 일시
	private Date inquiry_replyDateTime;
	public InquiryToAdminVO() {
		super();
	}
	public InquiryToAdminVO(int inquiry_no, String writer_nick, int admin_no, int inquiry_parent, String inquiry_title,
			String inquiry_content, Date inquiry_date, char inquiry_status, Date inquiry_replyDateTime, int customer_no) {
		super();
		this.inquiry_no = inquiry_no;
		this.writer_nick = writer_nick;
		this.inquiry_parent = inquiry_parent;
		this.inquiry_title = inquiry_title;
		this.inquiry_content = inquiry_content;
		this.customer_no = customer_no;
		this.inquiry_date = inquiry_date;
		this.inquiry_status = inquiry_status;
		this.inquiry_replyDateTime = inquiry_replyDateTime;
	}
	public int getInquiry_no() {
		return inquiry_no;
	}
	public void setInquiry_no(int inquiry_no) {
		this.inquiry_no = inquiry_no;
	}
	public int getInquiry_parent() {
		return inquiry_parent;
	}
	public void setInquiry_parent(int inquiry_parent) {
		this.inquiry_parent = inquiry_parent;
	}
	public String getInquiry_title() {
		return inquiry_title;
	}
	public void setInquiry_title(String inquiry_title) {
		this.inquiry_title = inquiry_title;
	}
	public String getInquiry_content() {
		return inquiry_content;
	}
	public void setInquiry_content(String inquiry_content) {
		this.inquiry_content = inquiry_content;
	}
	public Date getInquiry_date() {
		return inquiry_date;
	}
	public void setInquiry_date(Date inquiry_date) {
		this.inquiry_date = inquiry_date;
	}
	public char getInquiry_status() {
		return inquiry_status;
	}
	public void setInquiry_status(char inquiry_status) {
		this.inquiry_status = inquiry_status;
	}
	public Date getInquiry_replyDateTime() {
		return inquiry_replyDateTime;
	}
	public void setInquiry_replyDateTime(Date inquiry_replyDateTime) {
		this.inquiry_replyDateTime = inquiry_replyDateTime;
	}
	public String getWriter_nick() {
		return writer_nick;
	}
	public void setWriter_nick(String writer_nick) {
		this.writer_nick = writer_nick;
	}
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	
	
}
