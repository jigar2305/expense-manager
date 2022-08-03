package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CategoryBean;
import com.bean.SubcategoryBean;

@Repository
public class CategoryDao {
	@Autowired
	JdbcTemplate stmt;

	public List<CategoryBean> listcategory(int userid) {
		return stmt.query("select * from category where userid=?",new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class),new Object[] {userid});	
	}
	public List<SubcategoryBean> listsubcategory(int categoryid,int userid) {
		return stmt.query("select * from subcategory where categoryid=? and userid=?",new BeanPropertyRowMapper<SubcategoryBean>(SubcategoryBean.class),new Object[] {categoryid,userid});
	}

	public int addcategory(CategoryBean category) {
		return stmt.update("insert into category (categoryname,userid) values(?,?)",category.getCategoryname(),category.getUserid());
	}

	public int addsubcategory(SubcategoryBean subcategory) {
		return stmt.update("insert into subcategory (subcategoryname,categoryid,userid) values(?,?,?)",subcategory.getSubcategoryname(),subcategory.getCategoryid(),subcategory.getUserid());

	}

}
