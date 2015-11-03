package com.coxes.alina.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.data.domain.AuditorAware;

import com.coxes.alina.entity.User;

public class UserAuditorAware implements AuditorAware<User> {
	@Override
	public User getCurrentAuditor() {
		Subject subject = SecurityUtils.getSubject();
		Object object = subject.getPrincipal();
		return (User) object;
	}
}
