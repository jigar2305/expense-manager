package com.bean;

import java.sql.Date;
import java.sql.Time;

public class ExpenseBean {
	private Integer expanseid;
	private Integer categoryid;
	private String expansename;
	private Integer userid;
	private Integer spend;
	private String paymenttype;
	private Integer subcategoryid;
	private Date expansedate;
	private Time expansetime;
	private String paymentid;
	public Integer getSpend() {
		return spend;
	}
	public void setSpend(Integer spend) {
		this.spend = spend;
	}
	public String getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
	public String getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public String getExpansename() {
		return expansename;
	}
	public void setExpansename(String expansename) {
		this.expansename = expansename;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getSubcategoryid() {
		return subcategoryid;
	}
	public void setSubcategoryid(Integer subcategoryid) {
		this.subcategoryid = subcategoryid;
	}
	public Date getExpansedate() {
		return expansedate;
	}
	public void setExpansedate(Date expansedate) {
		this.expansedate = expansedate;
	}
	public Time getExpansetime() {
		return expansetime;
	}
	public void setExpansetime(Time expansetime) {
		this.expansetime = expansetime;
	}
	public Integer getExpanseid() {
		return expanseid;
	}
	public void setExpanseid(Integer expanseid) {
		this.expanseid = expanseid;
	}

}
