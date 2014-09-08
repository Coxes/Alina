package com.coxes.alina.utils;

import org.apache.shiro.SecurityUtils;

import com.coxes.alina.service.ShiroDbRealm.ShiroUser;

public class AlinaUtil {
	public static Long getUserid() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}
}
