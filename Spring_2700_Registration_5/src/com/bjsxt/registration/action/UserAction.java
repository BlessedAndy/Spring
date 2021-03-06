package com.bjsxt.registration.action;

import com.bjsxt.registration.model.User;
import com.bjsxt.registration.service.UserManager;
import com.bjsxt.registration.service.impl.UserManagerImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	private String username;
	private String password;
	private String password2;
	
	UserManager um = new UserManagerImpl();

	public UserManager getUm() {
		return um;
	}

	public void setUm(UserManager um) {
		this.um = um;
	}

	@Override
	public String execute() throws Exception {
		User u = new User();
		u.setUsername(username);
		u.setPassword(password); 
		if(um.exists(u)) {
			return "fail";
		}
		um.add(u);
		return "success";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
}
