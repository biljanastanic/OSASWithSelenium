package com.fit.ossa.pages.user;

import java.util.Date;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.DateField;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.util.EnumSelectModel;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.user.UserDAO;
import com.fit.ossa.entities.univesity.University;
import com.fit.ossa.entities.user.User;
import com.fit.ossa.model.md5.MD5;
import com.fit.ossa.model.type.UserType;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class AddUser {

	@Property
	@SessionState(create = false)
	private User user;
	@Inject
	private UserDAO userDAO;
	@InjectPage
	private ErrorPage errorPage;
	@Inject
	private AlertManager alertManager;
	@Property
	private UserType userType;
	@Inject
	private Messages messages;

	@Component
	private Form createForm;

	@Persist
	@Property
	private String error;

	@Persist
	@Property
	private String message;

	void onPrepare() {
		user = new User();
	}

	public SelectModel getTypes() {
		return new EnumSelectModel(UserType.class, messages);
	}

	Object onSubmitFromCreateForm() {
		error = "";
		message = "";
		Date now = new Date();
		if ((user.getUsername() == "" || user.getUsername() == null)
				|| (user.getPassword() == "" || user.getPassword() == null)
				|| (user.getEmail() == "" || user.getEmail() == null)) {
			error = "You must provide value for every field!";

		} else {
			user.setRole(userType);
			user.setPassword(MD5.md5(user.getPassword()));
			userDAO.save(user);
			message = "User successfully added!";

		}
		return null;
	}

	public boolean isValueNotNull() {
		if (message == null || message == "") {
			return false;
		}
		return true;
	}

	@OnEvent(component = "ResetValueLink")
	Object onResetConfLink() {
		message = "";
		return null;
	}

	@OnEvent(component = "ResetErrorLink")
	Object onResetErrorLink() {
		error = "";
		return null;
	}

	public boolean isErrorNotNull() {
		if (error == null || error == "") {
			return false;
		}
		return true;
	}

}
