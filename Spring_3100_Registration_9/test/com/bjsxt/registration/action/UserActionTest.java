package com.bjsxt.registration.action;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.registration.vo.UserRegisterInfo;

public class UserActionTest {

	@Test
	public void testExecute() throws Exception {
		UserAction ua = new UserAction();
		UserRegisterInfo info = new UserRegisterInfo();
		info.setUsername("x");
		info.setPassword("x");
		info.setPassword2("x");
		ua.setInfo(info);
		String ret = ua.execute();
		assertEquals("success", ret);
	}
	
	@Test
	public void testList() throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		UserAction ua = (UserAction)ctx.getBean("user");
		ua.list();
		assertTrue(ua.getUsers().size() > 0);
	}

}
