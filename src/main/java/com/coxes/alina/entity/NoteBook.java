package com.coxes.alina.entity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 记事本
 * 
 * @author vip
 *
 */
public class NoteBook extends BasicEntity {
	private static final long serialVersionUID = -8909754512287688181L;
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
