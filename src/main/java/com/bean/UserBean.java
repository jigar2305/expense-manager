package com.bean;

import org.hibernate.validator.constraints.NotBlank;

public class UserBean {
	private Integer userid;
	@NotBlank(message = "please enter firstname")
	private String firstname;
	@NotBlank(message = "please enter lastname")
	private String lastname;
	@NotBlank(message = "please enter email")
	private String email;
	@NotBlank(message = "please enter password")
	private String password;
	@NotBlank(message = "please enter question")
	private String question;
	@NotBlank(message = "please enter gender")
	private String gender;
	@NotBlank(message = "please enter answer")
	private String answer;
	private Boolean active;
	private String usertype;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
