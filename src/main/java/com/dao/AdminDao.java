package com.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CategoryBean;
import com.bean.UserBean;

@Repository
public class AdminDao {
	
	@Autowired
	JdbcTemplate stmTemplate;
	
	
	public List<UserBean> listcustomer(){
		return stmTemplate.query("select * from users where usertype='customer'",new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}
	
	public void activatecustemor(int userid,Boolean activate) {
		stmTemplate.update("update users set active=? where userid=?",activate,userid);
	}

	public Integer addcategory(@Valid CategoryBean category) {
		return stmTemplate.update("insert into category (categoryname,userid) values(?,?)",category.getCategoryname(),category.getUserid());		
	}
}
