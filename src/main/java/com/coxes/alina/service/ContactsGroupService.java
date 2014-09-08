package com.coxes.alina.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.coxes.alina.entity.ContactsGroup;
import com.coxes.alina.repository.ContactsGroupDao;

@Service
@Transactional
public class ContactsGroupService extends CrudService<ContactsGroupDao, ContactsGroup, Long> {

	public Iterable<ContactsGroup> findByUserId(Long userId) {
		return null;
	}
}
