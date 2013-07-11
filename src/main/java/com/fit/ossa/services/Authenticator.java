package com.fit.ossa.services;

import com.fit.ossa.entities.user.User;
import com.fit.ossa.security.AuthenticationException;

public interface Authenticator {

	public User getLoggedUser();

	public boolean isLoggedIn();

	public void login(String username, String password)
			throws AuthenticationException;

	public void logout();
}
