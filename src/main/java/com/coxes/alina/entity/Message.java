package com.coxes.alina.entity;

import javax.persistence.Entity;

import org.hibernate.envers.Audited;

@Audited
@Entity(name = "ala_message")
public class Message extends BasicEntity {
	private User receiver;
	private User sender;
}
