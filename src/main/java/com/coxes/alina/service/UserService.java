package com.coxes.alina.service;

import java.lang.reflect.InvocationTargetException;
import java.util.GregorianCalendar;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxes.alina.entity.User;
import com.coxes.alina.repository.UserDao;
import com.coxes.alina.web.vo.RegisterVo;

@Service
public class UserService extends CrudService<UserDao, User, Long> {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;

	@Override
	public Iterable<User> findAll() {
		return userDao.findAll();
	}

	public User findByPhone(String phone) {
		return userDao.findByPhone(phone);
	}

	public User save(RegisterVo vo) {
		User user = new User();
		try {
			BeanUtils.copyProperties(user, vo);
			GregorianCalendar birthday = new GregorianCalendar(vo.getBirthdayYear(), vo.getBirthdayMonth() - 1, vo.getBirthdayDay());
			return userDao.save(user);
		} catch (IllegalAccessException | InvocationTargetException e) {
			return null;
		}
	}
}
