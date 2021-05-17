package com.wc.pb.admin.vo;

public class NoticeBoardImgVO {
	
	//공지 게시판 이미지 번호
	private int nboard_img_no;
	//공지 게시판 번호
	private int nboard_no;
	//원본 파일이름
	private String nboard_oriFileName;
	//저장될 이름
	private String nboard_imgName;
	//저장될 장소
	private String nboard_location;
	public int getNboard_img_no() {
		return nboard_img_no;
	}
	public void setNboard_img_no(int nboard_img_no) {
		this.nboard_img_no = nboard_img_no;
	}
	public int getNboard_no() {
		return nboard_no;
	}
	public void setNboard_no(int nboard_no) {
		this.nboard_no = nboard_no;
	}
	public String getNboard_oriFileName() {
		return nboard_oriFileName;
	}
	public void setNboard_oriFileName(String nboard_oriFileName) {
		this.nboard_oriFileName = nboard_oriFileName;
	}
	public String getnboard_imgName() {
		return nboard_imgName;
	}
	public void setnboard_imgName(String nboard_imgName) {
		this.nboard_imgName = nboard_imgName;
	}
	public String getNboard_location() {
		return nboard_location;
	}
	public void setNboard_location(String nboard_location) {
		this.nboard_location = nboard_location;
	}
	public NoticeBoardImgVO(int nboard_img_no, int nboard_no, String nboard_oriFileName, String nboard_imgName,
			String nboard_location) {
		super();
		this.nboard_img_no = nboard_img_no;
		this.nboard_no = nboard_no;
		this.nboard_oriFileName = nboard_oriFileName;
		this.nboard_imgName = nboard_imgName;
		this.nboard_location = nboard_location;
	}
	public NoticeBoardImgVO() {
		super();
	}

}
