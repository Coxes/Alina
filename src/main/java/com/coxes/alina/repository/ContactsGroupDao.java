package com.coxes.alina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.coxes.alina.entity.ContactsGroup;

public interface ContactsGroupDao extends JpaRepository<ContactsGroup, Long>, JpaSpecificationExecutor<ContactsGroup> {

}
