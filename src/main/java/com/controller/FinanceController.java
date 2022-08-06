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
import com.bean.CashBean;
import com.bean.CreditcardBean;
import com.bean.DebitcardBean;
import com.bean.ExpenseBean;
import com.bean.PaytmBean;
import com.bean.UserBean;
import com.dao.FinanceDao;
import com.dao.ListDao;

@Controller
public class FinanceController {
	@Autowired
	FinanceDao financeDao;
	
	@Autowired
	ListDao dao;

	@GetMapping("/balance")
	public String balance(BalanceBean balance, Model model) {
		model.addAttribute("balance", balance);
		return "balance";
	}

	@PostMapping("/balance")
	public String savebalance(@ModelAttribute("balance") @Valid BalanceBean balance, BindingResult result,
			HttpSession session, Model model) {
		UserBean userBean = (UserBean) session.getAttribute("user");
		int userid = userBean.getUserid();
		balance.setUserid(userid);
		if (result.hasErrors()) {
			model.addAttribute("balance", balance);
			model.addAttribute("msg", "somethig went wrong");
			return "balance";
		} else {
			String type = balance.getFinancetype();
			int record = 0;
			if (type.equals("cash")) {
				if (financeDao.checkcash(userid) != null) {
					int cash = financeDao.checkcash(userid).getCash();
					balance.setBalance(cash + balance.getBalance());
					record = financeDao.updatecash(balance);
				} else {
					record = financeDao.addcash(balance);
				}
			} else if (type.equals("Paytm")) {
				if (financeDao.checkpaytm(balance) == 1) {
					model.addAttribute("balance", balance);
					model.addAttribute("paytmerror", "upiid alredy exist");
					return "balance";
				} else {
					record = financeDao.addpaytm(balance);
				}
			} else if (type.equals("Creditcard")) {
				if (financeDao.checkcreditcard(balance) == 1) {
					model.addAttribute("balance", balance);
					model.addAttribute("creditcarderror", "This card is  alredy registered");
					return "balance";
				} else {
					record = financeDao.addcreditcard(balance);
				}
			} else if (type.equals("Debitcard")) {
				if (financeDao.checkdebitcard(balance) == 1) {
					model.addAttribute("balance", balance);
					model.addAttribute("debitcarderror", "This card is  alredy registered");
					return "balance";
				} else {
					record = financeDao.adddebitcard(balance);
				}
			}

			if (record == 0) {
				model.addAttribute("balance", balance);
				model.addAttribute("msg", "somethig went wrong");
				return "balance";
			} else {
				model.addAttribute("balance", balance);
				return "redirect:/home";
			}
		}
	}
	
	
	@GetMapping("/listaccount")
	public String listaccount(ExpenseBean expense, Model model, HttpSession session) {
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		List<CashBean> cash = dao.getcash(userid);
		model.addAttribute("cashs", cash);
		List<PaytmBean> paytm = dao.getpaytm(userid);
		model.addAttribute("paytm", paytm);
		List<CreditcardBean> cc = dao.getcreditcard(userid);
		model.addAttribute("creditcard", cc);
		List<DebitcardBean> dc = dao.getdebitcard(userid);
		model.addAttribute("debitcard", dc);
		return "Listaccount";
	}

	
	
}
