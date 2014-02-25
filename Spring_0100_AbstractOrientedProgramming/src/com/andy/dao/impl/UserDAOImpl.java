package com.andy.dao.impl;

import com.andy.dao.UserDAO;
import com.andy.model.User;


public class UserDAOImpl implements UserDAO {

	@Override
	public void save(User user){
		System.out.println("a user saved!");
	}
}
