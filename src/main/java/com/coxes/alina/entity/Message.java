package com.coxes.alina.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity(name = "ala_message")
public class Message extends BasicEntity {
	private User receiver;
	private User sender;
	private String content;
	private Date sendTime;
}
