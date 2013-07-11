package com.fit.ossa.components.security;

import org.apache.tapestry5.corelib.base.AbstractConditional;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.services.Authenticator;

/**
 * Checks if the user is logged in
 * 
 */
public class Authenticated extends AbstractConditional {

	@Inject
	private Authenticator authenticator;

	@Override
	protected boolean test() {
		return authenticator.isLoggedIn();
	}

}
