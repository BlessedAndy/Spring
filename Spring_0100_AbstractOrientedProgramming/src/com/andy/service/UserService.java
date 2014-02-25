package com.andy.service;

import com.andy.dao.UserDAO;
import com.andy.dao.impl.UserDAOImpl;
import com.andy.model.User;

public class UserService {
	
	private UserDAO userDao;

	public void add(User user){
		this.userDao.save(user);
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
}
