package com.wc.pb.admin.vo;

public class NoticeBoardVO {

	//공지 게시판 번호
	private int nboard_no;
	//관리자 번호
	private int admin_no;
	//공지 제목
	private String nboard_title;
	//공지 내용
	private String nboard_content;
	//작성 일시
	private String nboard_date;
	//공지 조회수
	private int nboard_readCount;
	//공지 작성자
	private String admin_name;
	//공지 총페이지수
	private int notice_total;
	public int getNboard_no() {
		return nboard_no;
	}
	public void setNboard_no(int nboard_no) {
		this.nboard_no = nboard_no;
	}
	public int getAdmin_no() {
		return admin_no;
	}
	public void setAdmin_no(int admin_no) {
		this.admin_no = admin_no;
	}
	public String getNboard_title() {
		return nboard_title;
	}
	public void setNboard_title(String nboard_title) {
		this.nboard_title = nboard_title;
	}
	public String getNboard_content() {
		return nboard_content;
	}
	public void setNboard_content(String nboard_content) {
		this.nboard_content = nboard_content;
	}
	public String getNboard_date() {
		return nboard_date;
	}
	public void setNboard_date(String nboard_date) {
		this.nboard_date = nboard_date;
	}
	public int getNboard_readCount() {
		return nboard_readCount;
	}
	public void setNboard_readCount(int nboard_readCount) {
		this.nboard_readCount = nboard_readCount;
	}
	public NoticeBoardVO(int nboard_no, int admin_no, String nboard_title, String nboard_content, String nboard_date,
			int nboard_readCount) {
		super();
		this.nboard_no = nboard_no;
		this.admin_no = admin_no;
		this.nboard_title = nboard_title;
		this.nboard_content = nboard_content;
		this.nboard_date = nboard_date;
		this.nboard_readCount = nboard_readCount;
	}
	public NoticeBoardVO() {
		super();
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public int getNotice_total() {
		return notice_total;
	}
	public void setNotice_total(int notice_total) {
		this.notice_total = notice_total;
	}
	
}
