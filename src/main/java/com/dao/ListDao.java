package com.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CashBean;
import com.bean.CreditcardBean;
import com.bean.DebitcardBean;
import com.bean.PaytmBean;

@Repository
public class ListDao {
	@Autowired
	JdbcTemplate stmt;

	public List<CashBean> getcash(int userid) {
		return stmt.query("select * from cash where userid=?", new BeanPropertyRowMapper<CashBean>(CashBean.class),
				new Object[] { userid });
	}

	public List<PaytmBean> getpaytm(int userid) {
		return stmt.query("select * from paytm where userid=?", new BeanPropertyRowMapper<PaytmBean>(PaytmBean.class),
				new Object[] { userid });
	}

	public List<CreditcardBean> getcreditcard(int userid) {
		return stmt.query("select * from creditcard where userid=?",
				new BeanPropertyRowMapper<CreditcardBean>(CreditcardBean.class), new Object[] { userid });
	}

	public List<DebitcardBean> getdebitcard(int userid) {
		return stmt.query("select * from debitcard where userid=?",
				new BeanPropertyRowMapper<DebitcardBean>(DebitcardBean.class), new Object[] { userid });
	}
	
	
	public PaytmBean checkpaytm(int paymentid) {
		return stmt.queryForObject("select * from paytm where paytmid=?", new BeanPropertyRowMapper<PaytmBean>(PaytmBean.class),
				new Object[] { paymentid });
	}

	public CreditcardBean checkcreditcard(int paymentid) {
		return stmt.queryForObject("select * from creditcard where creditcardid=?",
				new BeanPropertyRowMapper<CreditcardBean>(CreditcardBean.class), new Object[] { paymentid });
	}

	public DebitcardBean checkdebitcard(int paymentid) {
		return stmt.queryForObject("select * from debitcard where debitcardid=?",
				new BeanPropertyRowMapper<DebitcardBean>(DebitcardBean.class), new Object[] { paymentid });
	}
	
	
	public int updatecash(int userid,int balance) {
		return stmt.update("update cash set cash=? where userid= ?", balance,userid);
	}
	public int updatepaytm(int id, int balance) {
		return stmt.update("update paytm set money=? where paytmid= ?", balance,id);
	}
	public int updatecredit(int id, int balance) {
		return stmt.update("update creditcard set \"limit\"=? where creditcardid= ?", balance,id);
		
	}public int updatedebit(int id, int balance) {
		return stmt.update("update debitcard set balance=? where debitcardid= ?", balance,id);
		
	}

}
