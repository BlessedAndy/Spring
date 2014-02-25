package com.bjsxt.registration.service;

import org.junit.Assert;

import org.junit.Test;

import com.bjsxt.registration.model.User;

public class UserManagerTest {

	@Test
	public void testExists() throws Exception {
		UserManager um = new UserManager();
		User u = new User();
		u.setUsername("andy");
		boolean exists = um.exists(u);
		Assert.assertEquals(true, exists);
	}

	@Test
	public void testAdd() throws Exception {
		UserManager um = new UserManager();
		User u = new User();
		u.setUsername("David");
		u.setPassword("123");
		boolean exists = um.exists(u);
		if(!exists) {
			um.add(u);
			Assert.assertEquals(true, um.exists(u));
			
		} else {
			Assert.fail("not added");
		}
		
	}

}
