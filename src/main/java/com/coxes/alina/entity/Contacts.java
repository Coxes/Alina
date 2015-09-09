package com.coxes.alina.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;

@Audited
@Entity(name = "ala_contacts")
public class Contacts extends BasicEntity {
	private static final long serialVersionUID = -1793206291567425228L;

	private String picture;
	private String lastName;
	private String firstName;
	private String phone;
	private String email;
	private ContactsGroup contactsGroup;

	@Column(length = 100)
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	@Column(length = 18)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne
	@JoinColumn(name = "contacts_group_id")
	public ContactsGroup getContactsGroup() {
		return contactsGroup;
	}

	public void setContactsGroup(ContactsGroup contactsGroup) {
		this.contactsGroup = contactsGroup;
	}

	@Transient
	public String getFullName() {
		return lastName + firstName;
	}
}
