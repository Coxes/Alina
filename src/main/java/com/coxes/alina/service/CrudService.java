package com.coxes.alina.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public abstract class CrudService<DAO extends CrudRepository<T, ID>, T, ID extends Serializable> {

	@Autowired
	protected DAO dao;

	public T findOne(ID id) {
		return dao.findOne(id);
	}

	public Iterable<T> findAll() {
		return dao.findAll();
	}

	public T save(T entity) {
		return dao.save(entity);
	}
}
