package com.wc.pb.customer.vo;

import java.util.Date;

public class MileageVO {

	//마일리지 번호
	private int mileage_no;
	//고객 지갑 번호
	private int customer_wallet_no;
	//총 마일리지
	private int mileage_amount;
	//마일리지 적립
	private int mileage_add;
	//마일리지 소모
	private int mileage_usage;
	//적립 or 소모 일시
	private Date mileage_date;
	public MileageVO() {
		super();
	}
	public MileageVO(int mileage_no, int customer_wallet_no, int mileage_amount, int mileage_add, int mileage_usage,
			Date mileage_date) {
		super();
		this.mileage_no = mileage_no;
		this.customer_wallet_no = customer_wallet_no;
		this.mileage_amount = mileage_amount;
		this.mileage_add = mileage_add;
		this.mileage_usage = mileage_usage;
		this.mileage_date = mileage_date;
	}
	public int getMileage_no() {
		return mileage_no;
	}
	public void setMileage_no(int mileage_no) {
		this.mileage_no = mileage_no;
	}
	public int getCustomer_wallet_no() {
		return customer_wallet_no;
	}
	public void setCustomer_wallet_no(int customer_wallet_no) {
		this.customer_wallet_no = customer_wallet_no;
	}
	public int getMileage_amount() {
		return mileage_amount;
	}
	public void setMileage_amount(int mileage_amount) {
		this.mileage_amount = mileage_amount;
	}
	public int getMileage_add() {
		return mileage_add;
	}
	public void setMileage_add(int mileage_add) {
		this.mileage_add = mileage_add;
	}
	public int getMileage_usage() {
		return mileage_usage;
	}
	public void setMileage_usage(int mileage_usage) {
		this.mileage_usage = mileage_usage;
	}
	public Date getMileage_date() {
		return mileage_date;
	}
	public void setMileage_date(Date mileage_date) {
		this.mileage_date = mileage_date;
	}
	
	
}
