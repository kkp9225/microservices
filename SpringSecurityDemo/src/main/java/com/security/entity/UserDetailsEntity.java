package com.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "password")
	private String pasword;

	public UserDetailsEntity() {}
	
	public UserDetailsEntity(int id, String username, String role, String pasword) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
		this.pasword = pasword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	@Override
	public String toString() {
		return "UserDetailsEntity [id=" + id + ", username=" + username + ", role=" + role + ", pasword=" + pasword
				+ "]";
	}
	
}
