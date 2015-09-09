package com.coxes.alina.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

@Audited
@Entity(name = "ala_user_detail")
public class UserDetail extends BasicEntity {
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
	/** 身份证 */
	private String identityCard;

	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@OneToOne(fetch = FetchType.LAZY)
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
