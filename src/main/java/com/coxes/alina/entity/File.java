package com.coxes.alina.entity;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity(name = "ala_file")
public class File extends BasicEntity {
	private static final long serialVersionUID = -5822492358987319935L;
	private String name;
	private String type;
	private Long size;
	private byte[] data;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	@Lob
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
