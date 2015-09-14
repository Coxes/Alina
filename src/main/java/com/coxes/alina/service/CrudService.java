package com.coxes.alina.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class CrudService<DAO extends JpaRepository<T, ID>, T, ID extends Serializable> {

	@Autowired
	protected DAO dao;

	public T findOne(ID id) {
		return dao.findOne(id);
	}

	public List<T> findAll() {
		return dao.findAll();
	}

	public T save(T entity) {
		return dao.save(entity);
	}
}
