package com.coxes.alina.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ala_contacts_group")
public class ContactsGroup extends BasicEntity {
	private static final long serialVersionUID = -7673149390646488501L;

	private String groupName;
	private User user;

	@Column(length = 30)
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
