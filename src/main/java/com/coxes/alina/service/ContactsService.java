package com.coxes.alina.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.coxes.alina.entity.Contacts;
import com.coxes.alina.repository.ContactsDao;
import com.coxes.alina.web.vo.PageVo;

@Service
public class ContactsService extends CrudService<ContactsDao, Contacts, Long> {
	public Page<Contacts> findByUserId(final Long userId) {
		return dao.findAll(new Specification<Contacts>() {
			@Override
			public Predicate toPredicate(Root<Contacts> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("contactsGroup").get("user").<Long> get("id"), userId);
			}
		}, new PageVo(1, 10));
	}
}
