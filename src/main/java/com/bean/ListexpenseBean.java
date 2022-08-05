package com.bean;

import java.sql.Date;

public class ListexpenseBean {
	private Integer expanseid;
	private String expensename;
	private Integer userid;
	private Integer spend;
	private String paymenttype;
	private Date expensedate;
	private String expensetime;
	private Integer paymentid;
	private String categoryname;
	private String subcategoryname;
	public Integer getExpanseid() {
		return expanseid;
	}
	public void setExpanseid(Integer expanseid) {
		this.expanseid = expanseid;
	}
	public String getExpensename() {
		return expensename;
	}
	public void setExpensename(String expensename) {
		this.expensename = expensename;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
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
	public Date getExpensedate() {
		return expensedate;
	}
	public void setExpensedate(Date expensedate) {
		this.expensedate = expensedate;
	}
	public String getExpensetime() {
		return expensetime;
	}
	public void setExpensetime(String expensetime) {
		this.expensetime = expensetime;
	}
	public Integer getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(Integer paymentid) {
		this.paymentid = paymentid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getSubcategoryname() {
		return subcategoryname;
	}
	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}

}
