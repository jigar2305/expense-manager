package com.bean;

import java.sql.Date;

public class ExpenseBean {
	private Integer expanseid;
	private Integer categoryid;
	private String expensename;
	private Integer userid;
	private Integer spend;
	private String paymenttype;
	private Integer subcategoryid;
	private Date expensedate;
	private String expensetime;
	private Integer paymentid;
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
	public Integer getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(Integer paymentid) {
		this.paymentid = paymentid;
	}

	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
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

}
