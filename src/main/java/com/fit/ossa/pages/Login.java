package com.fit.ossa.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;

import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AnonymousAccess;
import com.fit.ossa.security.AuthenticationException;
import com.fit.ossa.services.Authenticator;


@AnonymousAccess
public class Login {

	@Property
	private String username;

	@Property
	private String password;

	@Inject
	private Authenticator authenticator;

//	@Component
//	private Form loginForm;

	@Property
	@Persist
	private boolean test;

	@Property
	@Persist
	private String message;

	@Log
	public Object onSubmitFromLoginForm() {

		try {
			if (username == null) {
				test = true;
				message = "Type username!";
				return null;
			} else {
				if (password == null) {
					test = true;
					message = "Type password!";	
					return null;
				} else {

					authenticator.login(username, password);
					return Index.class;
				}
			}

		} catch (AuthenticationException ex) {
			test = true;
			message = "Wrong username or password!";
			return null;
		}
		
	}
}
