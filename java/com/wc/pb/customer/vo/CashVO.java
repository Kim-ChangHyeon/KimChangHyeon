package com.wc.pb.customer.vo;

import java.util.Date;

public class CashVO {

	// 캐시 번호
	private int cash_no;
	// 고객 지갑 번호
	private int customer_wallet_no;
	// 총 캐시
	private int cash_amount;
	// 캐시 충전
	private int cash_charge;
	// 캐시 사용
	private int cash_usage;
	// 사용 일시
	private Date cash_chargeDate;
	// 승인 일시
	private Date cash_authDate;
	// 결제수단
	private int cash_paymentMethod;
	// 승인여부
	private int cash_status;
	public CashVO(int cash_no, int customer_wallet_no, int cash_amount, int cash_charge, int cash_usage,
			Date cash_chargeDate, Date cash_authDate, int cash_paymentMethod, int cash_status) {
		super();
		this.cash_no = cash_no;
		this.customer_wallet_no = customer_wallet_no;
		this.cash_amount = cash_amount;
		this.cash_charge = cash_charge;
		this.cash_usage = cash_usage;
		this.cash_chargeDate = cash_chargeDate;
		this.cash_authDate = cash_authDate;
		this.cash_paymentMethod = cash_paymentMethod;
		this.cash_status = cash_status;
	}
	public CashVO() {
		super();
	}
	public int getCash_no() {
		return cash_no;
	}
	public void setCash_no(int cash_no) {
		this.cash_no = cash_no;
	}
	public int getCustomer_wallet_no() {
		return customer_wallet_no;
	}
	public void setCustomer_wallet_no(int customer_wallet_no) {
		this.customer_wallet_no = customer_wallet_no;
	}
	public int getCash_amount() {
		return cash_amount;
	}
	public void setCash_amount(int cash_amount) {
		this.cash_amount = cash_amount;
	}
	public int getCash_charge() {
		return cash_charge;
	}
	public void setCash_charge(int cash_charge) {
		this.cash_charge = cash_charge;
	}
	public int getCash_usage() {
		return cash_usage;
	}
	public void setCash_usage(int cash_usage) {
		this.cash_usage = cash_usage;
	}
	public Date getCash_chargeDate() {
		return cash_chargeDate;
	}
	public void setCash_chargeDate(Date cash_chargeDate) {
		this.cash_chargeDate = cash_chargeDate;
	}
	public Date getCash_authDate() {
		return cash_authDate;
	}
	public void setCash_authDate(Date cash_authDate) {
		this.cash_authDate = cash_authDate;
	}
	public int getCash_paymentMethod() {
		return cash_paymentMethod;
	}
	public void setCash_paymentMethod(int cash_paymentMethod) {
		this.cash_paymentMethod = cash_paymentMethod;
	}
	public int getCash_status() {
		return cash_status;
	}
	public void setCash_status(int cash_status) {
		this.cash_status = cash_status;
	}

	
	
}
