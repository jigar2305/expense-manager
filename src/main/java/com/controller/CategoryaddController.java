package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.CategoryBean;

@Controller
public class CategoryaddController {
	@GetMapping("/addcategory")
	public String addcategory(CategoryBean category,Model model){
		model.addAttribute("category",category);
		
		return null;
		
	}
}
