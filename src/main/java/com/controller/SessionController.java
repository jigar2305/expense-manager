package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.LoginBean;
import com.bean.MychartBean;
import com.bean.ProfileBean;
import com.bean.UserBean;
import com.dao.ExpenseDao;
import com.dao.ProfileDao;
import com.dao.UserDao;

@Controller
public class SessionController {
	@Autowired
	UserDao userDao;
	
	@Autowired
	ExpenseDao dao;
	
	@Autowired
	ProfileDao profileDao;
	
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
				if(user.getUsertype().equals("customer")) {	
					if(user.getActive()) {						
						return "redirect:/home";
					}else {
						model.addAttribute("msg", "your account is deactive please contact admin");

						return "login";

					}
				}else {
					return "redirect:/admin";
				}

			}
		}
	}
	
	@GetMapping("/home")
	public String home(HttpSession session,Model model) {
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		List<MychartBean> mychartBeans =  dao.listchart(userid);
		model.addAttribute("mycharts",mychartBeans);
		return"home";
	}
	@GetMapping("/profile")
	public String profile() {
		return"profile";
	}
	@PostMapping("/profile")
	public String saveimage(@RequestParam("image") MultipartFile file, HttpSession session){
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		String mainpath="E:\\SpringTool\\exp-manager\\src\\main\\resources\\static\\images";
		File folder = new File(mainpath,userid+"");
		folder.mkdir();
		File newfile = new File(folder,file.getOriginalFilename());
		try {
			byte []b = file.getBytes();
			FileOutputStream fos = new FileOutputStream(newfile);
			fos.write(b);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ProfileBean profile = new ProfileBean();
		profile.setUserid(userid);
		profile.setUrl("images/"+userid+"/"+file.getOriginalFilename());
		profile.setActive(false);
		
		   profileDao.setimage(profile);
		 		return "redirect:/listimage";
	}
	@GetMapping("/listimage")
	public String listimage(HttpSession session,Model model) {
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		List<ProfileBean> images = profileDao.listimage(userid);
		model.addAttribute("images",images);
		return "listimage";
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
