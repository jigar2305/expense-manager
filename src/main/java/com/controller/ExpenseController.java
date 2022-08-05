package com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.CashBean;
import com.bean.CategoryBean;
import com.bean.CreditcardBean;
import com.bean.DebitcardBean;
import com.bean.ExpenseBean;
import com.bean.ListexpenseBean;
import com.bean.PaytmBean;
import com.bean.SubcategoryBean;
import com.bean.UserBean;
import com.dao.CategoryDao;
import com.dao.ExpenseDao;
import com.dao.ListDao;

@Controller
public class ExpenseController {
	@Autowired
	CategoryDao categoryDao;

	@Autowired
	ListDao dao;
	
	@Autowired
	ExpenseDao expenseDao;
	

	@GetMapping("/expense")
	public String expanse(ExpenseBean expense, Model model, HttpSession session) {
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		model.addAttribute("expense", expense);
		List<CategoryBean> category = categoryDao.listcategory(userid);
		model.addAttribute("category", category);
		List<CashBean> cash = dao.getcash(userid);
		model.addAttribute("cash", cash);
		List<PaytmBean> paytm = dao.getpaytm(userid);
		model.addAttribute("paytm", paytm);
		List<CreditcardBean> cc = dao.getcreditcard(userid);
		model.addAttribute("creditcard", cc);
		List<DebitcardBean> dc = dao.getdebitcard(userid);
		model.addAttribute("debitcard", dc);
		
		SubcategoryBean subcategory = new SubcategoryBean();
		model.addAttribute("subcategory",subcategory);
		CategoryBean category1 = new CategoryBean();
		model.addAttribute("category1",category1);
		
		return "addexpense";
	}

	@PostMapping("/expense")
	public String addexpanse(@ModelAttribute("expense") ExpenseBean expense, BindingResult result, Model model,
			HttpSession session, @RequestParam("paymentid") Integer paymentid) {

		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		expense.setUserid(userid);
		expense.setPaymentid(paymentid);
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String dateString = dateFormat.format(new Date()).toString();
		expense.setExpensetime(dateString);
		int spend = expense.getSpend();
		String mode = expense.getPaymenttype();
		int id = expense.getPaymentid();
		int error = 0;
			if (mode.equals("cash")) {
				int money = dao.getcash(userid).get(0).getCash();
				if (money >= spend) {
					int balance = money - spend;
					error=dao.updatecash(userid, balance);
				}
			}else if (mode.equals("Paytm")) {
				int money = dao.checkpaytm(userid).getMoney();
				if (money >= spend) {
					int balance = money - spend;
					error=dao.updatepaytm(id, balance);
				}
			}else if (mode.equals("Creditcard")) {
				int money = dao.checkcreditcard(id).getLimit();
				if (money >= spend) {
					int balance = money - spend;
					error=dao.updatecredit(id, balance);
				}
			}else if (mode.equals("Debitcard")) {
				int money = dao.checkdebitcard(id).getBalance();
				if (money >= spend) {
					int balance = money - spend;
					error=dao.updatedebit(id, balance);
				}
			}
			{
			model.addAttribute("expense", expense);
			SubcategoryBean subcategory = new SubcategoryBean();
			model.addAttribute("subcategory",subcategory);
			CategoryBean category1 = new CategoryBean();
			model.addAttribute("category1",category1);
			List<CategoryBean> category = categoryDao.listcategory(userid);
			model.addAttribute("category", category);
			List<CashBean> cash = dao.getcash(userid);
			model.addAttribute("cash", cash);
			List<PaytmBean> paytm = dao.getpaytm(userid);
			model.addAttribute("paytm", paytm);
			List<CreditcardBean> cc = dao.getcreditcard(userid);
			model.addAttribute("creditcard", cc);
			List<DebitcardBean> dc = dao.getdebitcard(userid);
			model.addAttribute("debitcard", dc);
			}
			if(error==1) {
				expenseDao.addexpense(expense);
			}else {
				model.addAttribute("expensemoney","you don't have enough money");
				return "addexpense";
			}


		return "redirect:/listexpense";
	}

	@GetMapping("/listexpense")
	public String listexpense(HttpSession session,Model model) {
		int userid = ((UserBean) session.getAttribute("user")).getUserid();

		List<ListexpenseBean> espenses = expenseDao.expenselist(userid);
		model.addAttribute("espenses", espenses);
		return "listexpense";
				
	}
	
	

}
