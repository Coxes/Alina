package com.coxes.alina.web.vo;

import java.io.Serializable;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class PageVo implements Pageable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2180924208438059384L;

	private int page;
	private int size;
	private Sort sort;

	public PageVo(int page, int size) {
		this(page, size, null);
	}

	public PageVo(int page, int size, Direction direction, String... properties) {
		this(page, size, new Sort(direction, properties));
	}

	public PageVo(int page, int size, Sort sort) {

		if (page < 1) {
			throw new IllegalArgumentException("page不能小于1");
		}
		if (size < 1) {
			throw new IllegalArgumentException("size不能小于1");
		}

		this.page = page;
		this.size = size;
		this.sort = sort;
	}

	@Override
	public int getPageNumber() {
		return page;
	}

	@Override
	public int getPageSize() {
		return size;
	}

	@Override
	public int getOffset() {
		return (page - 1) * size;
	}

	@Override
	public Sort getSort() {
		return sort;
	}

	@Override
	public Pageable next() {
		return new PageVo(getPageNumber() + 1, getPageSize());
	}

	@Override
	public Pageable previousOrFirst() {
		return hasPrevious() ? new PageVo(getPageNumber() - 1, getPageSize()) : first();
	}

	@Override
	public Pageable first() {
		return new PageVo(1, getPageSize());
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return getPageNumber() > 1;
	}

	public Pageable previous() {
		return previousOrFirst();
	}

}
