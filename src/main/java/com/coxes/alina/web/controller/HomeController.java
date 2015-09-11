package com.coxes.alina.web.controller;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.coxes.alina.entity.User;
import com.coxes.alina.service.ContactsGroupService;
import com.coxes.alina.service.ContactsService;
import com.coxes.alina.service.UserService;
import com.coxes.alina.utils.AlinaUtil;
import com.coxes.alina.web.vo.RegisterVo;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	@Autowired
	private ContactsGroupService contactsGroupService;
	@Autowired
	private ContactsService contactsService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String toRegister() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(RegisterVo vo) {
		userService.save(vo);
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
		return "login";
	}

	@RequestMapping(value = "/")
	public String home(Integer page, Integer size, Model model) {
		User user = userService.findOne(AlinaUtil.getUserid());
		model.addAttribute("user", user);
		model.addAttribute("contacts", contactsService.findByUserId(user.getId()));
		return "/index";
	}
}
