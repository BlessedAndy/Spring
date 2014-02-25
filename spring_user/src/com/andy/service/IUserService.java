package com.andy.service;

import java.util.List;

import com.andy.model.Pager;
import com.andy.model.User;


public interface IUserService {
	public void add(User user);
	public void update(User user);
	public void delete(int id);
	public User load(int id);
	public List<User> list();
	public Pager<User> find();
	public User login(String username,String password);
}
