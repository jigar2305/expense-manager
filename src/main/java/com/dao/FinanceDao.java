package com.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.BalanceBean;
import com.bean.FinanceBean;

@Repository
public class FinanceDao {
	@Autowired
	JdbcTemplate stmt;

	public int addfinance(@Valid FinanceBean finance) {
		return stmt.update("insert into finance(userid,financetype) values(?,?)", finance.getUserid(),
				finance.getFinancetype());
	}

	public List<FinanceBean> getfinance(int userid) {
		return stmt.query("select financetype from finance where userid=?",
				new BeanPropertyRowMapper<FinanceBean>(FinanceBean.class), new Object[] { userid });
	}

	public int addbalance(@Valid BalanceBean balance) {

		return stmt.update(
				"INSERT INTO balance (cardnumber, balance, cardname, upiid, financetype, userid) VALUES (?, ?, ?, ?, ?, ?)",
				balance.getCardnumber(), balance.getBalance(), balance.getCardname(), balance.getUpiid(),
				balance.getFinancetype(), balance.getUserid());

	}

}
