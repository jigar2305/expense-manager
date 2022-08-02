package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CategoryBean;
import com.bean.SubcategoryBean;
import com.bean.UserBean;
import com.dao.CategoryDao;

@Controller
public class CategoryaddController {
	
	@Autowired
	CategoryDao categoryDao;
	
	@PostMapping("/addcategory")
	public String addcategory(@ModelAttribute("category1") CategoryBean category,BindingResult result,Model model,HttpSession session){
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		category.setUserid(userid);
		categoryDao.addcategory(category);
		model.addAttribute("category",category);
		return "redirect:/expense";
		
	}
	@PostMapping("/addsubcategory")
	public String addsubcategory(@ModelAttribute("subcategory") SubcategoryBean subcategory,BindingResult result,Model model,HttpSession session){
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		subcategory.setUserid(userid);
		categoryDao.addsubcategory(subcategory);
		return "redirect:/expense";
		
	}
}
