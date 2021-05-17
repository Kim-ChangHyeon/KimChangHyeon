package com.wc.pb.customer.vo;

import java.util.Date;

public class OrderVO {
	
	//주문 번호
	private int order_no;
	//고객 번호
	private int customer_no;
	//셀러 번호
	private int seller_no;
	//상품 번호
	private int product_no;
	//쿠폰 번호
	private int coupon_no;
	//사용한 마일리지
	private int order_useMileage;
	//총 할인한 가격
	private int order_totalDiscountPrice;
	//쿠폰 할인 가격
	private int order_couponDiscountPrice;
	//결제 방식
	private String order_payType;
	//결제 상태 (결제 완료, 미결제)
	private char order_status;
	//결제 일시
	private Date order_date;
	//총 가격
	private int totalPrice;
	//상품 가격
	private int price;
	//상품 제목
	private String title;
	//날짜 조회 시작
	private String fromDate;
	//날짜 조회 끝
	private String toDate;
	public OrderVO(int order_no, int customer_no, int seller_no, int product_no, int coupon_no, int order_useMileage,
			int order_totalDiscountPrice, int order_couponDiscountPrice, String order_payType, char order_status,
			Date order_date, int totalPrice, int price, String title, String fromDate, String toDate) {
		super();
		this.order_no = order_no;
		this.customer_no = customer_no;
		this.seller_no = seller_no;
		this.product_no = product_no;
		this.coupon_no = coupon_no;
		this.order_useMileage = order_useMileage;
		this.order_totalDiscountPrice = order_totalDiscountPrice;
		this.order_couponDiscountPrice = order_couponDiscountPrice;
		this.order_payType = order_payType;
		this.order_status = order_status;
		this.order_date = order_date;
		this.totalPrice = totalPrice;
		this.price = price;
		this.title = title;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public OrderVO() {
		super();
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	public int getSeller_no() {
		return seller_no;
	}
	public void setSeller_no(int seller_no) {
		this.seller_no = seller_no;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getCoupon_no() {
		return coupon_no;
	}
	public void setCoupon_no(int coupon_no) {
		this.coupon_no = coupon_no;
	}
	public int getOrder_useMileage() {
		return order_useMileage;
	}
	public void setOrder_useMileage(int order_useMileage) {
		this.order_useMileage = order_useMileage;
	}
	public int getOrder_totalDiscountPrice() {
		return order_totalDiscountPrice;
	}
	public void setOrder_totalDiscountPrice(int order_totalDiscountPrice) {
		this.order_totalDiscountPrice = order_totalDiscountPrice;
	}
	public int getOrder_couponDiscountPrice() {
		return order_couponDiscountPrice;
	}
	public void setOrder_couponDiscountPrice(int order_couponDiscountPrice) {
		this.order_couponDiscountPrice = order_couponDiscountPrice;
	}
	public String getOrder_payType() {
		return order_payType;
	}
	public void setOrder_payType(String order_payType) {
		this.order_payType = order_payType;
	}
	public char getOrder_status() {
		return order_status;
	}
	public void setOrder_status(char order_status) {
		this.order_status = order_status;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	

}
