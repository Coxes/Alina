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
	 * 根据手机号获取用户
	 */
	User findByPhone(String phone);

	/**
	 * 根据手机号和密码获取用户
	 */
	User findByPhoneAndPassword(String phone, String password);

}
