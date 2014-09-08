package com.coxes.alina.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.coxes.alina.entity.User;
import com.coxes.alina.repository.UserDao;

public class UserServiceTestBack {
	@InjectMocks
	private UserService userService;
	@Mock
	private UserDao userDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test1() {
		System.out.println(userService.save(new User()));
	}
}
