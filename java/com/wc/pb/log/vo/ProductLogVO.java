package com.wc.pb.log.vo;

import java.util.Date;

public class ProductLogVO {
	// 상품로고 번호
	private int plog_no;
	private int subCate_no;
	private int seller_no;
	// 상품 
	private int product_no;
	private String plog_exTitle;
	private String plog_afTitle;
	private String plog_exSkill;
	private String plog_afSkill;
	private String plog_Description;
	private int plog_exPrice;
	private int plog_afPrice;
	private int plog_exOperationDate;
	private int plog_afOperationDate;
	private Date plog_date;
	
	public ProductLogVO() {
		super();
	}

	public ProductLogVO(int plog_no, int subCate_no, int seller_no, int product_no, String plog_exTitle,
			String plog_afTitle, String plog_exSkill, String plog_afSkill, Date plog_date, int plog_exPrice,
			int plog_afPrice, String plog_Description, int plog_exOperationDate, int plog_afOperationDate) {
		super();
		this.plog_no = plog_no;
		this.subCate_no = subCate_no;
		this.seller_no = seller_no;
		this.product_no = product_no;
		this.plog_exTitle = plog_exTitle;
		this.plog_afTitle = plog_afTitle;
		this.plog_exSkill = plog_exSkill;
		this.plog_afSkill = plog_afSkill;
		this.plog_exOperationDate = plog_exOperationDate;
		this.plog_afOperationDate = plog_afOperationDate;
		this.plog_Description = plog_Description;
		this.plog_date = plog_date;
		this.plog_exPrice = plog_exPrice;
		this.plog_afPrice = plog_afPrice;
	}

	public int getPlog_no() {
		return plog_no;
	}

	public void setPlog_no(int plog_no) {
		this.plog_no = plog_no;
	}

	public int getSubCate_no() {
		return subCate_no;
	}

	public void setSubCate_no(int subCate_no) {
		this.subCate_no = subCate_no;
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

	public String getPlog_exTitle() {
		return plog_exTitle;
	}

	public void setPlog_exTitle(String plog_exTitle) {
		this.plog_exTitle = plog_exTitle;
	}

	public String getPlog_afTitle() {
		return plog_afTitle;
	}

	public void setPlog_afTitle(String plog_afTitle) {
		this.plog_afTitle = plog_afTitle;
	}

	public String getPlog_exSkill() {
		return plog_exSkill;
	}

	public void setPlog_exSkill(String plog_exSkill) {
		this.plog_exSkill = plog_exSkill;
	}

	public String getPlog_afSkill() {
		return plog_afSkill;
	}

	public void setPlog_afSkill(String plog_afSkill) {
		this.plog_afSkill = plog_afSkill;
	}

	public Date getPlog_date() {
		return plog_date;
	}

	public void setPlog_date(Date plog_date) {
		this.plog_date = plog_date;
	}

	public int getPlog_exPrice() {
		return plog_exPrice;
	}

	public void setPlog_exPrice(int plog_exPrice) {
		this.plog_exPrice = plog_exPrice;
	}

	public int getPlog_afPrice() {
		return plog_afPrice;
	}

	public void setPlog_afPrice(int plog_afPrice) {
		this.plog_afPrice = plog_afPrice;
	}

	public String getPlog_Description() {
		return plog_Description;
	}

	public void setPlog_Description(String plog_Description) {
		this.plog_Description = plog_Description;
	}

	public int getPlog_exOperationDate() {
		return plog_exOperationDate;
	}

	public void setPlog_exOperationDate(int plog_exOperationDate) {
		this.plog_exOperationDate = plog_exOperationDate;
	}

	public int getPlog_afOperationDate() {
		return plog_afOperationDate;
	}

	public void setPlog_afOperationDate(int plog_afOperationDate) {
		this.plog_afOperationDate = plog_afOperationDate;
	}

}
