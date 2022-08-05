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

import com.bean.LoginBean;
import com.bean.MychartBean;
import com.bean.UserBean;
import com.dao.ExpenseDao;
import com.dao.UserDao;

@Controller
public class SessionController {
	@Autowired
	UserDao userDao;
	
	@Autowired
	ExpenseDao dao;
	
	@GetMapping("/signup")
	public String signup(UserBean user,Model model) {
		model.addAttribute("user",user);
		return "signup";
	}
	@PostMapping("/signup")
	public String saveuser(@ModelAttribute("user") @Valid UserBean user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "signup";
		} else {
			if(userDao.getUserByEmail(user.getEmail())==null) {
				int record = userDao.adduser(user);
				if(record==1) {				
					model.addAttribute("msg", "signup successfully.....");
					return "redirect:/login";
				}else {
					model.addAttribute("user", user);
					model.addAttribute("msg","something went wrong");
					return "signup";
				}
			}else {
				model.addAttribute("user", user);
				model.addAttribute("duplicate","user already exist, please login");
				return "signup";
			}
		}
	}	
	
	@GetMapping("/login")
	public String login(LoginBean loginBean, Model model) {
		model.addAttribute(loginBean);
		return "login";
	}
	@PostMapping("/login")
	public String loginuser(@Valid LoginBean loginBean, BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute(loginBean);
			return "login";
		} else {
			UserBean user = userDao.login(loginBean);
			if (user == null) {
				model.addAttribute("msg", "invailid user");
				return "login";
			} else {
				session.setAttribute("user", user);
				return "redirect:/home";

			}
		}
	}
	
	@GetMapping("/home")
	public String home(HttpSession session,Model model) {
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		List<MychartBean> mychartBeans =  dao.listchart(userid);
		System.out.println(mychartBeans+"qwertyuiop[]");
		model.addAttribute("mycharts",mychartBeans);
		return"home";
	}
	@GetMapping("/navcustomer")
	public String navcustomer() {
		return"navcustomer";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
}
