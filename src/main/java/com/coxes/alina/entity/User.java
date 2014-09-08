package com.coxes.alina.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User extends IdEntity {
	/**
	 * Serializable ID
	 */
	private static final long serialVersionUID = 2925609031342843697L;

	private String username;
	private String password;
	private String lastName;
	private String firstName;
	private String phone;
	private Date birthday;
	private Set<ContactsGroup> contactsGroup;

	@Column(length = 20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(length = 20)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(length = 30)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(length = 15)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<ContactsGroup> getContactsGroup() {
		return contactsGroup;
	}

	public void setContactsGroup(Set<ContactsGroup> contactsGroup) {
		this.contactsGroup = contactsGroup;
	}
}
