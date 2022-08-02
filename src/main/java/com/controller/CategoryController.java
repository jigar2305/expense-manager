package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bean.SubcategoryBean;
import com.bean.UserBean;
import com.dao.CategoryDao;

@RestController
public class CategoryController {

	@Autowired
	CategoryDao categoryDao;

	@GetMapping("/subcategory/{categoryid}")
	public List<SubcategoryBean> subcategory(@PathVariable("categoryid") int categoryid, HttpSession session) {
		int userid = ((UserBean) session.getAttribute("user")).getUserid();
		return categoryDao.listsubcategory(categoryid, userid);
	}
}
