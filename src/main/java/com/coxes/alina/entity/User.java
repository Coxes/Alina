package com.coxes.alina.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class User extends IdEntity {
	private static final long serialVersionUID = 2925609031342843697L;
	/** 手机号 */
	private String phone;
	/** 密码 */
	private String password;
	/** 姓 */
	private String lastName;
	/** 名 */
	private String firstName;
	private UserDetail userDetail;

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

	@OneToOne(mappedBy = "user")
	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

}
