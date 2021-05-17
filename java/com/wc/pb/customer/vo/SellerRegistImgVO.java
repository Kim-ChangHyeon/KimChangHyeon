package com.wc.pb.customer.vo;

import java.util.Date;

public class SellerRegistImgVO {
	// 판매자 사진 번호
	private int sellerImg_no;
	// 판매자 번호
	private int seller_no;
	// 판매자 사진 원본 이름
	private String sellerImg_OriFileName;
	// 핀매자 사진 이름
	private String sellerImg_name;
	// 판매자 사진 경로
	private String sellerImg_location;
	// 사진 등록 시간
	private Date sellerImg_addDate;
	
	public SellerRegistImgVO() {
		super();
	}

	public SellerRegistImgVO(int sellerImg_no, int seller_no, String sellerImg_OriFileName, String sellerImg_name,
			String sellerImg_location, Date sellerImg_addDate) {
		super();
		this.sellerImg_no = sellerImg_no;
		this.seller_no = seller_no;
		this.sellerImg_OriFileName = sellerImg_OriFileName;
		this.sellerImg_name = sellerImg_name;
		this.sellerImg_location = sellerImg_location;
		this.sellerImg_addDate = sellerImg_addDate;
	}

	public int getSellerImg_no() {
		return sellerImg_no;
	}

	public void setSellerImg_no(int sellerImg_no) {
		this.sellerImg_no = sellerImg_no;
	}

	public int getSeller_no() {
		return seller_no;
	}

	public void setSeller_no(int seller_no) {
		this.seller_no = seller_no;
	}

	public String getSellerImg_OriFileName() {
		return sellerImg_OriFileName;
	}

	public void setSellerImg_OriFileName(String sellerImg_OriFileName) {
		this.sellerImg_OriFileName = sellerImg_OriFileName;
	}

	public String getSellerImg_name() {
		return sellerImg_name;
	}

	public void setSellerImg_name(String sellerImg_name) {
		this.sellerImg_name = sellerImg_name;
	}

	public String getSellerImg_location() {
		return sellerImg_location;
	}

	public void setSellerImg_location(String sellerImg_location) {
		this.sellerImg_location = sellerImg_location;
	}

	public Date getSellerImg_addDate() {
		return sellerImg_addDate;
	}

	public void setSellerImg_addDate(Date sellerImg_addDate) {
		this.sellerImg_addDate = sellerImg_addDate;
	}

	
}
