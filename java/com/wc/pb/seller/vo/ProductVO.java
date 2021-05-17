package com.wc.pb.seller.vo;

import java.util.Date;

public class ProductVO {
	
	// 상품 번호
	private int product_no;
	//판매자 번호
	private int seller_no;
	// 구매자 번호
	private int customer_no;
	//소분류 번호
	private int subCate_no;
	// 메인 카테고리
	private int mainCate_no;
	// 상품 제목
	private String product_title;
	// 보유 기술
	private String product_skill;
	// 상품
	private int product_operationDate;
	// 상품 가격
	private int product_price;
	// 상품 올린 날짜 
	private Date product_addDate;
	// 상품 판매 개수
	private int product_soldCount;
	// 상품 조회수
	private int product_readCount;
	// 상품 찜 수
	private int product_likeCount;
	// 평균 평점
	private float rating;
	// 리뷰 갯수
	private int reviewCount;
	// 메인카테 이름
	private String mainCate_name;
	// 서브카테 이름
	private String subCate_name;
	
	public ProductVO() {
		super();
	}

	public ProductVO(int product_no, int seller_no, int subCate_no,int mainCate_no, String product_title, String product_skill, int product_operationDate,
			int product_price, Date product_addDate, int product_soldCount, int product_readCount, int product_likeCount,
			float rating, int reviewCount, String subCate_name, String mainCate_name) {
		super();
		this.product_no = product_no;
		this.seller_no = seller_no;
		this.subCate_no = subCate_no;
		this.mainCate_no = mainCate_no;
		this.product_title = product_title;
		this.setProduct_skill(product_skill);
		this.product_operationDate = product_operationDate;
		this.product_price = product_price;
		this.product_addDate = product_addDate;
		this.product_soldCount = product_soldCount;
		this.product_readCount = product_readCount;
		this.product_likeCount = product_likeCount;
		this.subCate_name = subCate_name;
		this.mainCate_name = mainCate_name;
		this.rating = rating;
		this.reviewCount = reviewCount;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public int getSeller_no() {
		return seller_no;
	}

	public void setSeller_no(int seller_no) {
		this.seller_no = seller_no;
	}

	public int getSubCate_no() {
		return subCate_no;
	}

	public void setSubCate_no(int subCate_no) {
		this.subCate_no = subCate_no;
	}

	public String getProduct_title() {
		return product_title;
	}

	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}

	public int getProduct_operationDate() {
		return product_operationDate;
	}

	public void setProduct_operationDate(int product_operationDate) {
		this.product_operationDate = product_operationDate;
	}

	public Date getProduct_addDate() {
		return product_addDate;
	}

	public void setProduct_addDate(Date product_addDate) {
		this.product_addDate = product_addDate;
	}

	public int getProduct_soldCount() {
		return product_soldCount;
	}

	public void setProduct_soldCount(int product_soldCount) {
		this.product_soldCount = product_soldCount;
	}

	public int getProduct_readCount() {
		return product_readCount;
	}

	public void setProduct_readCount(int product_readCount) {
		this.product_readCount = product_readCount;
	}

	public int getProduct_likeCount() {
		return product_likeCount;
	}

	public void setProduct_likeCount(int product_likeCount) {
		this.product_likeCount = product_likeCount;
	}

	public int getCustomer_no() {
		return customer_no;
	}

	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_skill() {
		return product_skill;
	}

	public void setProduct_skill(String product_skill) {
		this.product_skill = product_skill;
	}

	public int getMainCate_no() {
		return mainCate_no;
	}

	public void setMainCate_no(int mainCate_no) {
		this.mainCate_no = mainCate_no;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getMainCate_name() {
		return mainCate_name;
	}

	public void setMainCate_name(String mainCate_name) {
		this.mainCate_name = mainCate_name;
	}

	public String getSubCate_name() {
		return subCate_name;
	}

	public void setSubCate_name(String subCate_name) {
		this.subCate_name = subCate_name;
	}
	
	
	
}
