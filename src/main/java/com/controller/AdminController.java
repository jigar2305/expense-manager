package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.CategoryBean;
import com.bean.UserBean;
import com.dao.AdminDao;

@Controller
public class AdminController {
	@Autowired
	AdminDao adminDao;
	
	@GetMapping("/admin")
	public String listUsers(Model model) {
		List<UserBean> usersBeans= adminDao.listcustomer();
		model.addAttribute("users",usersBeans);
		return"admin";
	}
	
	
	@GetMapping("/updatestatus")
	public String update(@RequestParam("activate") Boolean activate, @RequestParam("userid") Integer userid) {
		Boolean activeBoolean;
		if (activate) {
			activeBoolean = false;
		} else {
			activeBoolean = true;
		}
		adminDao.activatecustemor(userid, activeBoolean);
		return"redirect:/admin";
	}
	
	
	@GetMapping("/category")
	public String addcategory(CategoryBean categoryBean,Model model) {
		model.addAttribute("category",categoryBean);
		return"expense";
	}
	@PostMapping("/addcategorybyadmin")
	public String addcategorybyadmin(@Valid CategoryBean categoryBean,Model model,HttpSession session) {
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		categoryBean.setUserid(userid);
		adminDao.addcategory(categoryBean);
		model.addAttribute("category",categoryBean);
		return"redirect:/admin";
	}
}
