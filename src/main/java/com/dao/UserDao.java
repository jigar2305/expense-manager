package com.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.LoginBean;
import com.bean.UserBean;

@Repository
public class UserDao {
	
	@Autowired
	JdbcTemplate stmt;

	public int adduser(@Valid UserBean user) {
		int record = stmt.update(
				"insert into users(firstname,lastname,email,password,question,answer,gender) values(?,?,?,?,?,?,?)",
				user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword(), user.getQuestion(),
				user.getAnswer(), user.getGender());
		return record;
	}

	public UserBean login(LoginBean loginBean) {
		UserBean user = null;
		try {

			user = stmt.queryForObject("select * from users where email=? and password=?",
					new BeanPropertyRowMapper<UserBean>(UserBean.class),
					new Object[] { loginBean.getEmail(), loginBean.getPassword() });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public UserBean getUserByEmail(String email) {

		List<UserBean> users = null;
		try {
			users = stmt.query("select * from users where email = ? ",
					new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { email });
		} catch (Exception e) {
			System.out.println("user not present!!!");
		}
		if (users.size() == 0) {
			return null;
		} else {
			return users.get(0);
		}
	}

}
