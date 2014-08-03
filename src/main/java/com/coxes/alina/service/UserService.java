package com.coxes.alina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxes.alina.entity.User;
import com.coxes.alina.repository.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public Iterable<User> findAll() {
		return userDao.findAll();
	}
}
