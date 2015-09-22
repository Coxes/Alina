package com.coxes.alina.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coxes.alina.entity.User;
import com.coxes.alina.repository.UserDao;
import com.coxes.alina.web.vo.RegisterVo;

@Service
public class UserService extends CrudService<UserDao, User, Long> {
	@Autowired
	private PasswordEncoder passwordEncoder;

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	public User findByPhone(String phone) {
		return dao.findByPhone(phone);
	}

	public User register(RegisterVo vo) {
		User user = new User();
		try {
			BeanUtils.copyProperties(user, vo);
			user.setPassword(passwordEncoder.encode(vo.getPassword()));
			return this.save(user);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error("创建 User 对象异常", e);
			return null;
		}
	}
}
