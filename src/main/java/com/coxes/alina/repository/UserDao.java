/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.coxes.alina.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.coxes.alina.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {
	/**
	 * 获取用户，根据用户名和密码
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);
}
