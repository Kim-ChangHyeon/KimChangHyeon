package com.wc.pb.customer.vo;

public class MyCouponVO {

	//내 쿠폰 번호
	private int myCoupon_no;
	//고객 지갑 번호
	private int customer_wallet_no;
	//쿠폰 번호
	private int coupon_no;
	//쿠폰 사용여부
	private char myCoupon_status;
	public int getMyCoupon_no() {
		return myCoupon_no;
	}
	public void setMyCoupon_no(int myCoupon_no) {
		this.myCoupon_no = myCoupon_no;
	}
	public int getCustomer_wallet_no() {
		return customer_wallet_no;
	}
	public void setCustomer_wallet_no(int customer_wallet_no) {
		this.customer_wallet_no = customer_wallet_no;
	}
	public int getCoupon_no() {
		return coupon_no;
	}
	public void setCoupon_no(int coupon_no) {
		this.coupon_no = coupon_no;
	}
	public char getMyCoupon_status() {
		return myCoupon_status;
	}
	public void setMyCoupon_status(char myCoupon_status) {
		this.myCoupon_status = myCoupon_status;
	}
	public MyCouponVO(int myCoupon_no, int customer_wallet_no, int coupon_no, char myCoupon_status) {
		super();
		this.myCoupon_no = myCoupon_no;
		this.customer_wallet_no = customer_wallet_no;
		this.coupon_no = coupon_no;
		this.myCoupon_status = myCoupon_status;
	}
	public MyCouponVO() {
		super();
	}
}
