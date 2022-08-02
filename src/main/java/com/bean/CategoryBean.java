package com.bean;

import org.hibernate.validator.constraints.NotBlank;

public class CategoryBean {
	private Integer categoryid;
	@NotBlank(message = "please enter category")
	private String categoryname;
	private Integer userid;
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
}
