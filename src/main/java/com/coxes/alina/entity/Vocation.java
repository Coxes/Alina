package com.coxes.alina.entity;

import javax.persistence.Entity;

import org.hibernate.envers.Audited;

@Audited
@Entity(name = "ala_vocation")
public class Vocation extends BasicEntity {
	private static final long serialVersionUID = -3405902044711874729L;

}
