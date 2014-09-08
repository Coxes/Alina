package com.coxes.alina.service;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.coxes.alina.entity.Contacts;
import com.coxes.alina.test.SpringTransactionalTestCase;

public class ContactsServiceTest extends SpringTransactionalTestCase {
	@Autowired
	private ContactsService contactsService;
	@Autowired
	private ContactsGroupService contactsGroupService;

	@Test
	// @Rollback(false)
	public void insert() {

		Contacts contacts = new Contacts();
		contacts.setBirthday(new Date());
		contacts.setContactsGroup(contactsGroupService.findOne(5l));
		contacts.setPhone("13631779280");
		contacts.setFirstName("云");
		contacts.setLastName("马");

		contactsService.save(contacts);
	}
}
