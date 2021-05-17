package com.wc.pb.customer.vo;

import java.util.Date;

public class CustomerImgVO {
	
	//고객 이미지 번호
	private int customer_imgNo;
	//고객 번호
	private int customer_no;
	//고객 이미지 원본 이름
	private String customer_imgOriFileName;
	//변경될 이름
	private String customer_imgName;
	//저장될 장소
	private String customer_imgLocation;
	//사진 저장시간
	private Date img_addDateTime;
	
	public CustomerImgVO() {
		super();
	}

	public CustomerImgVO(int customer_imgNo, int customer_no, String customer_imgOriFileName, String customer_imgName,
			String customer_imgLocation, Date img_addDateTime) {
		super();
		this.customer_imgNo = customer_imgNo;
		this.customer_no = customer_no;
		this.customer_imgOriFileName = customer_imgOriFileName;
		this.customer_imgName = customer_imgName;
		this.customer_imgLocation = customer_imgLocation;
		this.img_addDateTime = img_addDateTime;
	}

	public int getCustomer_imgNo() {
		return customer_imgNo;
	}

	public void setCustomer_imgNo(int customer_imgNo) {
		this.customer_imgNo = customer_imgNo;
	}

	public int getCustomer_no() {
		return customer_no;
	}

	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}

	public String getCustomer_imgOriFileName() {
		return customer_imgOriFileName;
	}

	public void setCustomer_imgOriFileName(String customer_imgOriFileName) {
		this.customer_imgOriFileName = customer_imgOriFileName;
	}

	public String getCustomer_imgName() {
		return customer_imgName;
	}

	public void setCustomer_imgName(String customer_imgName) {
		this.customer_imgName = customer_imgName;
	}

	public String getCustomer_imgLocation() {
		return customer_imgLocation;
	}

	public void setCustomer_imgLocation(String customer_imgLocation) {
		this.customer_imgLocation = customer_imgLocation;
	}

	public Date getImg_addDateTime() {
		return img_addDateTime;
	}

	public void setImg_addDateTime(Date img_addDateTime) {
		this.img_addDateTime = img_addDateTime;
	}

	
	
}
