package com.wc.pb.seller.vo;

import java.util.Date;

public class WithdrawVO {
	// 출금 번호
	private int withdraw_no;
	// 판매자 번호
	private int seller_no;
	// 출금 계좌
	private String withdraw_account;
	// 출금 전 잔액
	private int withdraw_balanceBfWithdraw;
	// 출금 후 잔액
	private int withdraw_balanceAfWithdraw;
	// 출금액
	private int withdraw_amount;
	// 출금 은행 타입
	private String withdraw_bankType;
	// 출금 일시
	private Date withdraw_dateTime;
	
	public WithdrawVO() {
		super();
	}

	public WithdrawVO(int withdraw_no, int seller_no, String withdraw_account, int withdraw_balanceBfWithdraw,
			int withdraw_balanceAfWithdraw, int withdraw_amount, String withdraw_bankType, Date withdraw_dateTime) {
		super();
		this.withdraw_no = withdraw_no;
		this.seller_no = seller_no;
		this.withdraw_account = withdraw_account;
		this.withdraw_balanceBfWithdraw = withdraw_balanceBfWithdraw;
		this.withdraw_balanceAfWithdraw = withdraw_balanceAfWithdraw;
		this.withdraw_amount = withdraw_amount;
		this.withdraw_bankType = withdraw_bankType;
		this.withdraw_dateTime = withdraw_dateTime;
	}

	public int getWithdraw_no() {
		return withdraw_no;
	}

	public void setWithdraw_no(int withdraw_no) {
		this.withdraw_no = withdraw_no;
	}

	public int getSeller_no() {
		return seller_no;
	}

	public void setSeller_no(int seller_no) {
		this.seller_no = seller_no;
	}

	public String getWithdraw_account() {
		return withdraw_account;
	}

	public void setWithdraw_account(String withdraw_account) {
		this.withdraw_account = withdraw_account;
	}

	public int getWithdraw_balanceBfWithdraw() {
		return withdraw_balanceBfWithdraw;
	}

	public void setWithdraw_balanceBfWithdraw(int withdraw_balanceBfWithdraw) {
		this.withdraw_balanceBfWithdraw = withdraw_balanceBfWithdraw;
	}

	public int getWithdraw_balanceAfWithdraw() {
		return withdraw_balanceAfWithdraw;
	}

	public void setWithdraw_balanceAfWithdraw(int withdraw_balanceAfWithdraw) {
		this.withdraw_balanceAfWithdraw = withdraw_balanceAfWithdraw;
	}

	public int getWithdraw_amount() {
		return withdraw_amount;
	}

	public void setWithdraw_amount(int withdraw_amount) {
		this.withdraw_amount = withdraw_amount;
	}

	public String getWithdraw_bankType() {
		return withdraw_bankType;
	}

	public void setWithdraw_bankType(String withdraw_bankType) {
		this.withdraw_bankType = withdraw_bankType;
	}

	public Date getWithdraw_dateTime() {
		return withdraw_dateTime;
	}

	public void setWithdraw_dateTime(Date withdraw_dateTime) {
		this.withdraw_dateTime = withdraw_dateTime;
	}

	
}
