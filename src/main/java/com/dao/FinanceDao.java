package com.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.BalanceBean;
import com.bean.CashBean;
import com.bean.CreditcardBean;
import com.bean.DebitcardBean;
import com.bean.PaytmBean;

@Repository
public class FinanceDao {
	@Autowired
	JdbcTemplate stmt;

	public int addcash(@Valid BalanceBean balance) {
		return stmt.update("INSERT INTO cash(cash, userid)VALUES (?, ?)", balance.getBalance(), balance.getUserid());

	}

	public int updatecash(@Valid BalanceBean balance) {
		return stmt.update("update cash set cash=? where userid= ?", balance.getBalance(), balance.getUserid());
	}
	

	public int addpaytm(@Valid BalanceBean balance) {
		return stmt.update("INSERT INTO paytm(upiid, money, userid)VALUES (?, ?, ?)", balance.getUpiid(),
				balance.getBalance(), balance.getUserid());

	}

	public int addcreditcard(@Valid BalanceBean balance) {
		return stmt.update("INSERT INTO creditcard( cardname, cardnumber, \"limit\", userid)VALUES (?, ?, ?, ?)",
				balance.getCardname(), balance.getCardnumber(), balance.getBalance(), balance.getUserid());

	}

	public int adddebitcard(@Valid BalanceBean balance) {
		return stmt.update("INSERT INTO debitcard(cardname, cardnumber, balance, userid)VALUES (?,?, ?, ?)",
				balance.getCardname(), balance.getCardnumber(), balance.getBalance(), balance.getUserid());

	}

	public CashBean checkcash(int userid) {
		 return stmt.queryForObject("select * from cash where userid=?", new BeanPropertyRowMapper<CashBean>(CashBean.class),
				new Object[] { userid });
		
	}
	public Integer checkpaytm(BalanceBean balanceBean) {
		List<PaytmBean> ids = stmt.query("select * from paytm where upiid=? and userid=?", new BeanPropertyRowMapper<PaytmBean>(PaytmBean.class),
				new Object[] { balanceBean.getUpiid(),balanceBean.getUserid() });
		if (ids.size() == 1) {
			return 1;
		} else {
			return 0;
		}
	}
	public Integer checkcreditcard(BalanceBean balanceBean) {
		List<CreditcardBean> ids = stmt.query("select * from creditcard where cardnumber=? and userid=?", new BeanPropertyRowMapper<CreditcardBean>(CreditcardBean.class),
				new Object[] { balanceBean.getCardnumber(),balanceBean.getUserid() });
		if (ids.size() == 1) {
			return 1;
		} else {
			return 0;
		}
	}
	public Integer checkdebitcard(BalanceBean balanceBean) {
		List<DebitcardBean> ids = stmt.query("select * from debitcard where cardnumber=? and userid=?", new BeanPropertyRowMapper<DebitcardBean>(DebitcardBean.class),
				new Object[] { balanceBean.getCardnumber(),balanceBean.getUserid() });
		if (ids.size() == 1) {
			return 1;
		} else {
			return 0;
		}
	}

}
