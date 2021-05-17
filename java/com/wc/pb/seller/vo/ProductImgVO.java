package com.wc.pb.seller.vo;

public class ProductImgVO {
	// 상품 이미지 번호
	private int productImg_no;
	// 상품 번호
	private int product_no;
	// 상품 이미지 기본 이름
	private String productOriFile_name;
	// 상품 이미지 이름
	private String productImg_name;
	// 상품 이미지 경로
	private String productImg_location;
	public ProductImgVO() {
		super();
	}
	public ProductImgVO(int productImg_no, int product_no, String productOriFile_name, String productImg_name,
			String productImg_location) {
		super();
		this.productImg_no = productImg_no;
		this.product_no = product_no;
		this.productOriFile_name = productOriFile_name;
		this.productImg_name = productImg_name;
		this.productImg_location = productImg_location;
	}
	public int getProductImg_no() {
		return productImg_no;
	}
	public void setProductImg_no(int productImg_no) {
		this.productImg_no = productImg_no;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public String getProductOriFile_name() {
		return productOriFile_name;
	}
	public void setProductOriFile_name(String productOriFile_name) {
		this.productOriFile_name = productOriFile_name;
	}
	public String getProductImg_name() {
		return productImg_name;
	}
	public void setProductImg_name(String productImg_name) {
		this.productImg_name = productImg_name;
	}
	public String getProductImg_location() {
		return productImg_location;
	}
	public void setProductImg_location(String productImg_location) {
		this.productImg_location = productImg_location;
	}
	
	
}
