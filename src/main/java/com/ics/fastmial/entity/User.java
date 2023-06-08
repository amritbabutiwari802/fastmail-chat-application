package com.ics.fastmial.entity;


import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
})
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public long id;


	@Column(nullable = false)
	private String username;

	private String name;

	public User() {
	}

	public User(String name, String username) {

		this.name = name;
		this.username = username;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "{" + "'" + ", name='" + getName() + "'" + ", username='" + getUsername() + "'" + "}";
	}

}
