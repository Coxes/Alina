package com.coxes.alina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.coxes.alina.entity.Contacts;

public interface ContactsDao extends JpaRepository<Contacts, Long>, JpaSpecificationExecutor<Contacts> {

}
