package com.fit.ossa.services;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.Session;

import com.fit.ossa.dao.user.UserDAO;
import com.fit.ossa.entities.user.User;
import com.fit.ossa.model.md5.MD5;
import com.fit.ossa.security.AuthenticationException;

public class BasicAuthenticator implements Authenticator {

	public static final String AUTH_TOKEN = "authToken";

	@Inject
	private UserDAO userDAO;

	@Inject
	private Request request;

	public void login(String username, String password)
			throws AuthenticationException {
		 password = MD5.md5(password);
		User user = userDAO.findByUserNameAndPassword(username, password);

		if (user == null) {
			throw new AuthenticationException("The user doesn't exist");
		}

		request.getSession(true).setAttribute(AUTH_TOKEN, user);
	}

	public boolean isLoggedIn() {
		Session session = request.getSession(false);
		if (session != null) {
			return session.getAttribute(AUTH_TOKEN) != null;
		}
		return false;
	}

	public void logout() {
		Session session = request.getSession(false);
		if (session != null) {
			session.setAttribute(AUTH_TOKEN, null);
			session.invalidate();
		}
	}

	public User getLoggedUser() {
		User user = null;

		if (isLoggedIn()) {
			user = (User) request.getSession(true).getAttribute(AUTH_TOKEN);
		} else {
			throw new IllegalStateException("The user is not logged ! ");
		}
		return user;
	}

}
