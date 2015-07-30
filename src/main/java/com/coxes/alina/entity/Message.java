package com.coxes.alina.entity;

import javax.persistence.Entity;

@Entity(name = "ala_message")
public class Message {
	private User receiver;
	private User sender;
}
