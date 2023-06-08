package com.ics.fastmial.entity;

import jakarta.persistence.*;

@Entity()
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
})
public class Auth {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;

	@Column(nullable = false)
	public String username;
	
	public String password;
	
	public Auth() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Auth(String username, String password) {
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Auth [username=" + username + ", password=" + password + "]";
	}



}
