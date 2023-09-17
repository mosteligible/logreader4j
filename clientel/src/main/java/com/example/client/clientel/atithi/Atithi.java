package com.example.client.clientel.atithi;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Atithi {
	@Id
	private String id;
	private String name;
	private String token;
	private String plan;

	public Atithi() {}
	
	public Atithi(String id, String name, String token, String plan) {
		this.id = id;
		this.name = name;
		this.token = token;
		this.plan = plan;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "Atithi [id=" + id + ", name=" + name + ", plan=" + plan + "]";
	}
}
