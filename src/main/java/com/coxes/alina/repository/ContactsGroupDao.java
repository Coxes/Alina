package com.coxes.alina.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.coxes.alina.entity.ContactsGroup;

public interface ContactsGroupDao extends PagingAndSortingRepository<ContactsGroup, Long>, JpaSpecificationExecutor<ContactsGroup> {

}
