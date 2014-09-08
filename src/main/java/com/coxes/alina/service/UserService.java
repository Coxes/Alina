package com.coxes.alina.service;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

	public Iterable<User> findAll() {
		return userDao.findAll();
	}

	public User findByUsernameAndPassword(String username, String password) {
		return userDao.findByUsernameAndPassword(username, password);
	}

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	public User save(RegisterVo vo) {
		User user = new User();
		try {
			BeanUtils.copyProperties(user, vo);
			GregorianCalendar birthday = new GregorianCalendar(vo.getBirthdayYear(), vo.getBirthdayMonth() - 1, vo.getBirthdayDay());
			user.setBirthday(birthday.getTime());
			return userDao.save(user);
		} catch (IllegalAccessException | InvocationTargetException e) {
			return null;
		}
	}
}
