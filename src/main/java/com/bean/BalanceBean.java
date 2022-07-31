package com.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class BalanceBean {
	private Integer cardid;
	private String cardnumber;
	@NotNull(message = "please enter balance")
	private Integer balance;
	private String cardname;
	private String upiid;
	private int userid;
	@NotBlank
	private String financetype;

	
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
	public Integer getCardid() {
		return cardid;
	}
	public void setCardid(Integer cardid) {
		this.cardid = cardid;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	public String getCardname() {
		return cardname;
	}
	public void setCardname(String cardname) {
		this.cardname = cardname;
	}
	public String getUpiid() {
		return upiid;
	}
	public void setUpiid(String upiid) {
		this.upiid = upiid;
	}

}
