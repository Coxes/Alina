package com.coxes.alina.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.coxes.alina.entity.ContactsGroup;
import com.coxes.alina.test.SpringTransactionalTestCase;

public class ContactsGroupServiceTest extends SpringTransactionalTestCase {
	@Autowired
	private ContactsGroupService contactsGroupService;
	@Autowired
	private UserService userService;

	@Test
	// @Rollback(false)
	public void test1() {
		ContactsGroup entity = new ContactsGroup();
		entity.setGroupName("朋友");
		entity.setUser(userService.findByPhone("13631557021"));
		contactsGroupService.save(entity);
		System.out.println(entity.getId());
	}

	@Test
	public void test2() {
		for (ContactsGroup contactsGroup : contactsGroupService.findAll()) {
			System.out.println(contactsGroup.getUser().getPhone());
		}

	}
}
