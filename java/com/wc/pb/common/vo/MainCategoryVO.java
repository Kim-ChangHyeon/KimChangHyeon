package com.wc.pb.common.vo;

public class MainCategoryVO {
	
	//메인 카테고리 번호
	private int mainCate_no;
	//메인 카테고리 이름
	private String mainCate_name;
	public MainCategoryVO() {
		super();
	}
	public MainCategoryVO(int mainCate_no, String mainCate_name) {
		super();
		this.mainCate_no = mainCate_no;
		this.mainCate_name = mainCate_name;
	}
	public int getMainCate_no() {
		return mainCate_no;
	}
	public void setMainCate_no(int mainCate_no) {
		this.mainCate_no = mainCate_no;
	}
	public String getMainCate_name() {
		return mainCate_name;
	}
	public void setMainCate_name(String mainCate_name) {
		this.mainCate_name = mainCate_name;
	}
	
}
