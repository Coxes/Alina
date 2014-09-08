package com.coxes.alina.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.coxes.alina.entity.Contacts;

public interface ContactsDao extends PagingAndSortingRepository<Contacts, Long>, JpaSpecificationExecutor<Contacts> {

}
