package com.bean;

import org.hibernate.validator.constraints.NotBlank;

public class FinanceBean {
	
	private int financeid;
	private int userid;
	@NotBlank
	private String financetype;
	public int getFinanceid() {
		return financeid;
	}
	public void setFinanceid(int financeid) {
		this.financeid = financeid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFinancetype() {
		return financetype;
	}
	public void setFinancetype(String financetype) {
		this.financetype = financetype;
	}
	

}
