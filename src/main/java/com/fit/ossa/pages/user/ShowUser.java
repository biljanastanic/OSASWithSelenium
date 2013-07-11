package com.fit.ossa.pages.user;

import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.user.UserDAO;
import com.fit.ossa.entities.user.User;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class ShowUser {

	@Property
	private List<User> users;
	@Property
	private User user;
	@Inject
	private UserDAO userDAO;
	@InjectPage
	private ErrorPage errorPage;

	void onActivate() {
		users = userDAO.findAll();
	}

	@OnEvent(component = "deleteLink")
	Object onDeleteLink(Long id) {
		try {
			userDAO.deleteByID(id);
			return null;
		} catch (Exception e) {
			errorPage.setMessage("Mistake!");
			return errorPage;
		}
	}

}
