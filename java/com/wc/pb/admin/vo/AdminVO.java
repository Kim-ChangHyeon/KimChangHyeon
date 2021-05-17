package com.wc.pb.admin.vo;

public class AdminVO {

	//어드민 번호
	private int admin_no;
	//어드민 아이디
	private String admin_id;
	//어드민 이름
	private String admin_name;
	//어드민 비밀번호
	private String admin_password;
	
	
public AdminVO() {
	super();
}

	public AdminVO(int admin_no, String admin_password, String admin_name, String admin_id) {
		super();
		this.admin_no = admin_no;
		this.admin_password = admin_password;
		this.admin_name = admin_name;
		this.admin_id = admin_id;
	}

	public int getAdmin_no() {
		return admin_no;
	}

	public void setAdmin_no(int admin_no) {
		this.admin_no = admin_no;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	
	
	
	
	
	
}
