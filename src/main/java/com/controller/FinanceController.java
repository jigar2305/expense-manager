package com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.BalanceBean;
import com.bean.UserBean;
import com.dao.FinanceDao;

@Controller
public class FinanceController {
	@Autowired
	FinanceDao financeDao;

	@GetMapping("/balance")
	public String balance(BalanceBean balance, Model model) {
		model.addAttribute("balance", balance);
		return "balance";
	}

	@PostMapping("/balance")
	public String savebalance(@ModelAttribute("balance") @Valid BalanceBean balance, BindingResult result,
			HttpSession session, Model model) {
		UserBean userBean = (UserBean) session.getAttribute("user");
		System.out.println(userBean);
		int userid = userBean.getUserid();
		System.out.println(userid);
		balance.setUserid(userid);
		if (result.hasErrors()) {
			model.addAttribute("balance", balance);
			model.addAttribute("msg", "somethig went wrong");
			return "balance";
		} else {
			String type = balance.getFinancetype();
			int record = 0;
			if (type.equals("cash")) {
				record = financeDao.addcash(balance);
			} else if (type.equals("Paytm")) {
				record = financeDao.addpaytm(balance);
			} else if (type.equals("Creditcard")) {
				record =financeDao.addcreditcard(balance);
			} else if (type.equals("Debitcard")) {
				record =financeDao.adddebitcard(balance);
			}

			if (record == 0) {
				model.addAttribute("balance", balance);
				model.addAttribute("msg", "somethig went wrong");
				return "balance";
			} else {
				model.addAttribute("balance", balance);
				return "home";
			}
		}
	}
}
