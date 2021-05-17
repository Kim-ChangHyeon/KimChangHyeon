package com.wc.pb.customer.vo;

import java.util.Date;

public class LikeVO {

	//찜 번호
	private int like_no;
	//제품 번호
	private int product_no;
	private int bno;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	//고객 번호
	private int customer_no;
	//찜한 일시
	private Date like_date;
	//상품 제목
	private String product_title;
	//찜 확인
	private int like_check;
	public int getLike_check() {
		return like_check;
	}
	public void setLike_check(int like_check) {
		this.like_check = like_check;
	}
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
	public int getLike_no() {
		return like_no;
	}
	public void setLike_no(int like_no) {
		this.like_no = like_no;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	public Date getLike_date() {
		return like_date;
	}
	public void setLike_date(Date like_date) {
		this.like_date = like_date;
	}
	public LikeVO(int like_no, int product_no, int customer_no, Date like_date, String product_title,int like_check, int bno) {
		super();
		this.like_no = like_no;
		this.product_no = product_no;
		this.customer_no = customer_no;
		this.like_date = like_date;
		this.product_title = product_title;
		this.like_check = like_check;
		this.bno = bno;
	}
	public LikeVO() {
		super();
	}
}
