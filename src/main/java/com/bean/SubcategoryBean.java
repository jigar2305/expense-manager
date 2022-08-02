package com.bean;

public class SubcategoryBean {
	private Integer subcategoryid;
	private Integer categoryid;
	private String subcategoryname;
	private Integer userid;
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public Integer getSubcategoryid() {
		return subcategoryid;
	}
	public void setSubcategoryid(Integer subcategoryid) {
		this.subcategoryid = subcategoryid;
	}
	public String getSubcategoryname() {
		return subcategoryname;
	}
	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}
