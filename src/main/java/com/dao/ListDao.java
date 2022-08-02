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

}
