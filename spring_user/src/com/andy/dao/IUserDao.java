package com.andy.dao;

import java.util.List;

import com.andy.model.Pager;
import com.andy.model.User;


public interface IUserDao {
	public void add(User user);
	public void update(User user);
	public void delete(int id);
	public User load(int id);
	public List<User> list();
	public Pager<User> find();
	public User loadByUsername(String username);
}
