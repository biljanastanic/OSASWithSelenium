package com.fit.ossa.pages.user;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.user.UserDAO;
import com.fit.ossa.entities.user.User;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class DetailUser {

	@Property
	@Persist
	private User user;
	@Inject
	private UserDAO userDAO;
	@InjectPage
	private ErrorPage errorPage;

	Object onActivate(Long id) {
		user = userDAO.findByID(id);
		if (user == null) {
			// errorPage.setMessage("Mistake! ");
			return null;
		}
		return null;

	}

}
