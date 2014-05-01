package com.woniper.hibernate.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Member")
public class Member implements Serializable {

	private static final long serialVersionUID = -8194241371081230947L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Size(min = 1, message = "입력하세요.")
	private String name;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date joined = new Date();
	
	@NotNull
	private char delState = '0';

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoined() {
		return joined;
	}

	public void setJoined(Date joined) {
		this.joined = joined;
	}

	public char getDelState() {
		return delState;
	}

	public void setDelState(char delState) {
		this.delState = delState;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", joined=" + joined
				+ ", delState=" + delState + "]";
	}
}
