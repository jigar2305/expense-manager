package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CashBean;
import com.bean.CreditcardBean;
import com.bean.DebitcardBean;
import com.bean.PaytmBean;
import com.bean.UserBean;
import com.dao.ListDao;

@RestController
public class ListController {
	
	@Autowired
	ListDao listDao;
	
	
	@GetMapping("/cash")
	public List<CashBean> cash(HttpSession session){
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		return listDao.getcash(userid);
	}
	@GetMapping("/paytm")
	public List<PaytmBean> paytm(HttpSession session){
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		return listDao.getpaytm(userid);
	}
	@GetMapping("/creditcard")
	public List<CreditcardBean> creditcard(HttpSession session){
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		return listDao.getcreditcard(userid); 
	}
	@GetMapping("/debitcard")
	public List<DebitcardBean> debitCash(HttpSession session){
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		return listDao.getdebitcard(userid);
	}


	

}
