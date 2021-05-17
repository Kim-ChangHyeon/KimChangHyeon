package com.wc.pb.common.vo;

public class SubCategoryVO {
	// 소분류 번호
	private int subCate_no;
	// 대분류 번호
	private int mainCate_no;
	// 소분류 이름
	private String subCate_name;
	
	public SubCategoryVO() {
		super();
	}

	public SubCategoryVO(int subCate_no, int mainCate_no, String subCate_name) {
		super();
		this.subCate_no = subCate_no;
		this.mainCate_no = mainCate_no;
		this.subCate_name = subCate_name;
	}

	public int getSubCate_no() {
		return subCate_no;
	}

	public void setSubCate_no(int subCate_no) {
		this.subCate_no = subCate_no;
	}

	public int getMainCate_no() {
		return mainCate_no;
	}

	public void setMainCate_no(int mainCate_no) {
		this.mainCate_no = mainCate_no;
	}

	public String getSubCate_name() {
		return subCate_name;
	}

	public void setSubCate_name(String subCate_name) {
		this.subCate_name = subCate_name;
	}
	
	
}
