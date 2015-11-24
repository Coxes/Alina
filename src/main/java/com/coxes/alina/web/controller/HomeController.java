package com.coxes.alina.web.controller;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.coxes.alina.entity.User;
import com.coxes.alina.service.ContactsGroupService;
import com.coxes.alina.service.ContactsService;
import com.coxes.alina.service.UserService;
import com.coxes.alina.web.vo.RegisterVo;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	@Autowired
	private ContactsGroupService contactsGroupService;
	@Autowired
	private ContactsService contactsService;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private ActiveMQQueue destination;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String toRegister() {
		return "register";
	}

	@RequestMapping(value = "/do-register", method = RequestMethod.POST)
	public String doRegister(RegisterVo vo) {
		userService.register(vo);
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

		System.out.println(1111);

		jmsTemplate.send(destination, new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(new User());
			}
		});

		// User user = userService.findOne(AlinaUtil.getUserid());
		// model.addAttribute("user", user);
		// model.addAttribute("users", user);
		// model.addAttribute("contacts",
		// contactsService.findByUserId(user.getId()));
		return "/index";
	}
}
