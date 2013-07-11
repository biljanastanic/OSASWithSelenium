package com.fit.ossa.pages;

import org.apache.tapestry5.annotations.Persist;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.annotations.FacultyAccess;
import com.fit.ossa.annotations.StudentAccess;


@AdminAccess
@FacultyAccess
@StudentAccess
public class ErrorPage {
	
	@Persist
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
