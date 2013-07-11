package com.fit.ossa.pages.user;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.user.UserDAO;
import com.fit.ossa.entities.user.User;
import com.fit.ossa.model.md5.MD5;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class EditUser {
	
	@Property
	@Persist
	private User user;
	@Inject
	private UserDAO userDAO;
	@InjectPage
	private ErrorPage errorPage;
	@Property
	private String newPassword;

	Object onActivate(Long id) {
		user = userDAO.findByID(id);
		if (user == null) {
			errorPage.setMessage("Mistake! ");
			return errorPage;
		}
		return null;
	}

	Object onSuccess() {
		try {

			if (newPassword != null) {
				newPassword = MD5.md5(newPassword);
				if (newPassword.equals(user.getPassword())) {
					user.setPassword((newPassword));
				}
			}
			userDAO.update(user);
			return ShowUser.class;
		} catch (Exception e) {
			errorPage.setMessage("Mistake! ");
			return errorPage;
		}

	}

}
