package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CashBean;
import com.bean.CategoryBean;
import com.bean.CreditcardBean;
import com.bean.DebitcardBean;
import com.bean.ExpenseBean;
import com.bean.PaytmBean;
import com.bean.SubcategoryBean;
import com.bean.UserBean;
import com.dao.CategoryDao;
import com.dao.ListDao;

@Controller
public class ExpenseController {
	@Autowired
	CategoryDao categoryDao;

	@Autowired
	ListDao dao;

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
	public String addexpanse(ExpenseBean expense, Model model) {
		

		model.addAttribute("expense", expense);

		return "addexpense";
	}
}
