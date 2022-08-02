package com.dao;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.BalanceBean;

@Repository
public class FinanceDao {
	@Autowired
	JdbcTemplate stmt;

	public int addcash(@Valid BalanceBean balance) {
		return stmt.update("INSERT INTO public.cash(cash, userid)VALUES (?, ?)", balance.getBalance(),
				balance.getUserid());

	}

	public int addpaytm(@Valid BalanceBean balance) {
		return stmt.update("INSERT INTO public.paytm(upiid, money, userid)VALUES (?, ?, ?)", balance.getUpiid(),
				 balance.getBalance(),balance.getUserid());

	}

	public int addcreditcard(@Valid BalanceBean balance) {
		return stmt.update("INSERT INTO public.creditcard( cardname, cardnumber, \"limit\", userid)VALUES (?, ?, ?, ?)",
				balance.getCardname(), balance.getCardnumber(), balance.getBalance(), balance.getUserid());

	}

	public int adddebitcard(@Valid BalanceBean balance) {
		return stmt.update("INSERT INTO public.debitcard(cardname, cardnumber, balance, userid)VALUES (?,?, ?, ?)",
				balance.getCardname(), balance.getCardnumber(), balance.getBalance(), balance.getUserid());

	}

}
