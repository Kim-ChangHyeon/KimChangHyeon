package com.wc.pb.customer.vo;

import java.util.Date;

public class CouponVO {
	
	
	//쿠폰 번호
	private int coupon_no;
	//쿠폰 이름
	private String coupon_name;
	//할인가격
	private int coupon_discountPrice;
	//할인률
	private int coupon_discountPercent;
	//발급일시
	private Date coupon_date;
	//쿠폰 코드
	private String coupon_code;
	//유효여부
	private String coupon_status;
	//유효여부
	private String coupon_expireDate;
	
	public CouponVO() {
		super();
	}

	
	public CouponVO(int coupon_no, String coupon_name, int coupon_discountPrice, int coupon_discountPercent,
			Date coupon_date, String coupon_code, String coupon_status, String coupon_expireDate) {
		super();
		this.coupon_no = coupon_no;
		this.coupon_name = coupon_name;
		this.coupon_discountPrice = coupon_discountPrice;
		this.coupon_discountPercent = coupon_discountPercent;
		this.coupon_date = coupon_date;
		this.setCoupon_expireDate(coupon_expireDate);
		this.coupon_code = coupon_code;
		this.coupon_status = coupon_status;
	}


	public int getCoupon_no() {
		return coupon_no;
	}


	public void setCoupon_no(int coupon_no) {
		this.coupon_no = coupon_no;
	}


	public String getCoupon_name() {
		return coupon_name;
	}


	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}


	public int getCoupon_discountPrice() {
		return coupon_discountPrice;
	}


	public void setCoupon_discountPrice(int coupon_discountPrice) {
		this.coupon_discountPrice = coupon_discountPrice;
	}


	public int getCoupon_discountPercent() {
		return coupon_discountPercent;
	}


	public void setCoupon_discountPercent(int coupon_discountPercent) {
		this.coupon_discountPercent = coupon_discountPercent;
	}


	public Date getCoupon_date() {
		return coupon_date;
	}


	public void setCoupon_date(Date coupon_date) {
		this.coupon_date = coupon_date;
	}


	public String getCoupon_code() {
		return coupon_code;
	}


	public void setCoupon_code(String coupon_code) {
		this.coupon_code = coupon_code;
	}


	public String getCoupon_status() {
		return coupon_status;
	}


	public void setCoupon_status(String coupon_status) {
		this.coupon_status = coupon_status;
	}


	public String getCoupon_expireDate() {
		return coupon_expireDate;
	}


	public void setCoupon_expireDate(String coupon_expireDate) {
		this.coupon_expireDate = coupon_expireDate;
	}



	
}
