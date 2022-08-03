package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ExpenseBean;

@Repository
public class ExpenseDao {
	@Autowired
	JdbcTemplate stmt;

	public int addexpense(ExpenseBean expense) {
		return stmt.update("INSERT INTO expense(expensename, spend, paymentid, categoryid, subcategoryid,expensetime,paymenttype)VALUES (?, ?, ?, ?, ?, ?,?)",
				expense.getExpensename(),expense.getSpend(),expense.getPaymentid(),expense.getCategoryid(),expense.getSubcategoryid(),expense.getExpensetime(),expense.getPaymenttype());
	}
	
	
}
