package com.andy.service;

import org.junit.Test;

import com.andy.dao.UserDAO;
import com.andy.model.User;
import com.andy.spring.BeanFactory;
import com.andy.spring.ClassPathXmlApplicationContext;

public class UserServiceTest {

	@Test
	public void testAdd() throws Exception{
		BeanFactory factory = new ClassPathXmlApplicationContext();
		
		UserService service = (UserService)factory.getBean("userService");
//		UserDAO userDAO = (UserDAO)factory.getBean("u");
//		service.setUserDao(userDAO);
		User user = new User();
		service.add(user);
		
	}

}
