package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ProfileBean;

@Repository
public class ProfileDao {
    
	@Autowired
	JdbcTemplate stmt;
	
	
	public void setimage(ProfileBean profile) {
		stmt.update("insert into profile (url,active,userid) values(?,?,?)",profile.getUrl(),profile.getActive(),profile.getUserid());	
	}
	
	
	public List<ProfileBean> listimage(int userid) {
		return  stmt.query("select * from profile where userid=?" ,new BeanPropertyRowMapper<ProfileBean>(ProfileBean.class),new Object[] {userid});
	}
}
