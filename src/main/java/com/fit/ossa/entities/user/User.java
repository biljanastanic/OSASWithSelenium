package com.fit.ossa.entities.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

import com.fit.ossa.model.type.UserType;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	@Column(name = "user_id")
	private Long id;
	@Validate("required")
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	@Validate("required")
	@Column(name = "password", nullable = false)
	private String password;
	@Validate("required")
	@Column(name = "email", nullable = false)
	private String email;
	@Validate("required")
	@Column(nullable = false, name = "role")
	private UserType role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getRole() {
		return role;
	}

	public void setRole(UserType role) {
		this.role = role;
	}

	public boolean isAdmin() {
		if (role == UserType.Admin) {
			return true;
		}
		return false;
	}

	public boolean isFaculty() {
		if (role == UserType.Faculty) {
			return true;
		}
		return false;
	}

	public boolean isProfessor() {
		if (role == UserType.Professor) {
			return true;
		}
		return false;
	}

	public boolean isStudent() {
		if (role == UserType.Student) {
			return true;
		}
		return false;
	}

}
