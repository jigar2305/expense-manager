package com.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ExpenseBean;
import com.bean.ListexpenseBean;
import com.bean.MychartBean;

@Repository
public class ExpenseDao {
	@Autowired
	JdbcTemplate stmt;

	public int addexpense(ExpenseBean expense) {
		return stmt.update("INSERT INTO expense(expensename, spend, paymentid, categoryid, subcategoryid,expensetime,paymenttype,userid)VALUES (?, ?, ?, ?, ?, ?,?,?)",
				expense.getExpensename(),expense.getSpend(),expense.getPaymentid(),expense.getCategoryid(),expense.getSubcategoryid(),expense.getExpensetime(),expense.getPaymenttype(),expense.getUserid());
	}
	public List<ListexpenseBean> expenselist(Integer userid,LocalDate begindate,LocalDate enddate) {
		return stmt.query("select expensename,spend,paymentid,paymenttype,categoryname,subcategoryname,expensedate,expensetime  from expense e,category cy,subcategory sb,user u where e.categoryid=cy.categoryid and e.subcategoryid=sb.subcategoryid and e.userid=? and expensedate BETWEEN ? AND ?",new BeanPropertyRowMapper<ListexpenseBean>(ListexpenseBean.class),
				new Object[] {userid,begindate,enddate});
	}
	
	public List<MychartBean> listchart(int userid) {
		return stmt.query("select sum(spend) as spends, categoryname from expense e inner join category ct on e.categoryid=ct.categoryid and e.userid=?  group by categoryname",new BeanPropertyRowMapper<MychartBean>(MychartBean.class),new Object[] {userid});
	}
	
	
}
