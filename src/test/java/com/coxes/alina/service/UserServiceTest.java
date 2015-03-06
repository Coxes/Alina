package com.coxes.alina.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.coxes.alina.entity.User;
import com.coxes.alina.test.SpringTransactionalTestCase;

public class UserServiceTest extends SpringTransactionalTestCase {
	@Autowired
	private UserService userService;

	@Test
	public void test1() {

		// System.out.println(userService.findByUsername("admin").getContactsGroup().isEmpty());
	}

	@Test
	// @Rollback(false)
	public void test2() {

		User user = new User();
		user.setLastName("xiaoming");
		userService.save(user);

		// System.out.println(userService.findByUsername("admin").getContactsGroup().isEmpty());
	}
}
