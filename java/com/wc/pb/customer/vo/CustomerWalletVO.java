package com.wc.pb.customer.vo;

public class CustomerWalletVO {
	
	//고객 지갑 번호
	private int customer_wallet_no;
	//고객 번호
	private int customer_no;
	
	

	public CustomerWalletVO() {
		super();
	}
	
	

	public CustomerWalletVO(int customer_wallet_no, int customer_no) {
		super();
		this.customer_wallet_no = customer_wallet_no;
		this.customer_no = customer_no;
	}



	public int getCustomer_wallet_no() {
		return customer_wallet_no;
	}



	public void setCustomer_wallet_no(int customer_wallet_no) {
		this.customer_wallet_no = customer_wallet_no;
	}



	public int getCustomer_no() {
		return customer_no;
	}



	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}




	
}
