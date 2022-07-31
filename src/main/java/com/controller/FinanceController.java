package com.controller;

import java.util.List;

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
import com.bean.FinanceBean;
import com.bean.UserBean;
import com.dao.FinanceDao;

@Controller
public class FinanceController {
	@Autowired
	FinanceDao financeDao;

	@GetMapping("/finance")
	public String finance(FinanceBean finance, Model model) {
		model.addAttribute("finance", finance);
		return "finance";
	}

	@PostMapping("/finance")
	public String savefinance(@ModelAttribute("finance") @Valid FinanceBean finance, BindingResult result,
			HttpSession session, Model model) {
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		finance.setUserid(userid);
		if (result.hasErrors()) {
			model.addAttribute("finance", finance);
			model.addAttribute("msg", "somethig went wrong");
			return "finance";
		} else {

			int record = financeDao.addfinance(finance);
			if (record == 0) {
				model.addAttribute("finance", finance);
				model.addAttribute("msg", "somethig went wrong");
				return "finance";
			} else {
				model.addAttribute("finance", finance);
				return "home";
			}
		}
	}

	@GetMapping("/balance")
	public String balance(BalanceBean balance, Model model, HttpSession session) {
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		List<FinanceBean> finance = financeDao.getfinance(userid);
		model.addAttribute("finance", finance);
		model.addAttribute("balance", balance);
		return "balance";
	}

	@PostMapping("/balance")
	public String savebalance(@ModelAttribute("balance") @Valid BalanceBean balance, BindingResult result,
			HttpSession session, Model model) {
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		balance.setUserid(userid);
		if (result.hasErrors()) {
			model.addAttribute("balance", balance);
			model.addAttribute("msg", "somethig went wrong");
			return "balance";
		} else {
			String type = balance.getFinancetype();
			balance.setUserid(userid);

			if (type.equals("cash")) {
				balance.setCardname(null);
				balance.setCardnumber(null);
				balance.setUpiid(null);
			} else if (type.equals("Paytm")) {
				balance.setCardname(null);
				balance.setCardnumber(null);
			} else {
				balance.setUpiid(null);
			}

			int record = financeDao.addbalance(balance);
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
