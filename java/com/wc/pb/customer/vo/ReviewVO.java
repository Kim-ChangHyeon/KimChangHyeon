package com.wc.pb.customer.vo;

import java.util.Date;

public class ReviewVO {
	// 후기 번호
	private int review_no;
	// 구매자 번호
	private int customer_no;
	// 상품 번호
	private int product_no;
	// 후기 타겟
	private int review_parent;
	// 후기 내용
	private String review_content;
	// 후기 별점
	private int review_rating;
	// 후기 조회수
	private int review_readCount;
	// 후기 작성 날짜
	private Date review_writeDate;
	// 후기 개수
	private int count;
	// 상품 제목
	private String product_title;
	public ReviewVO() {
		super();
	}
	public ReviewVO(int review_no, int customer_no, int product_no, int review_parent, String review_content,
			int review_rating, int review_readCount, Date review_writeDate, int count, String product_title) {
		super();
		this.review_no = review_no;
		this.customer_no = customer_no;
		this.product_no = product_no;
		this.review_parent = review_parent;
		this.review_content = review_content;
		this.review_rating = review_rating;
		this.review_readCount = review_readCount;
		this.review_writeDate = review_writeDate;
		this.count = count;
		this.product_title = product_title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getReview_parent() {
		return review_parent;
	}
	public void setReview_parent(int review_parent) {
		this.review_parent = review_parent;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public int getReview_rating() {
		return review_rating;
	}
	public void setReview_rating(int review_rating) {
		this.review_rating = review_rating;
	}
	public int getReview_readCount() {
		return review_readCount;
	}
	public void setReview_readCount(int review_readCount) {
		this.review_readCount = review_readCount;
	}
	public Date getReview_writeDate() {
		return review_writeDate;
	}
	public void setReview_writeDate(Date review_writeDate) {
		this.review_writeDate = review_writeDate;
	}
	public String getProduct_title() {
		return product_title;
	}
	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}
	
	
}
