package com.coxes.alina.entity;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class UserDetail extends IdEntity {
	private static final long serialVersionUID = -1712527460101687278L;
	private User user;
	/** 电子邮件 */
	private String email;
	/** 生日 */
	private Date birthday;
	/** 性别 */
	private String sex;
	/** 故乡 */
	private String hometown;

	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@OneToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

}
