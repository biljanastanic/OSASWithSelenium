package com.fit.ossa.pages.programme;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.programme.ProgrammeDAO;
import com.fit.ossa.entities.programme.Programme;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class EditProgramme {

	@Property
	@Persist
	private Programme programme;
	@Inject
	private ProgrammeDAO programmeDAO;
	@InjectPage
	private ErrorPage errorPage;
	@Persist
	@Property
	private String error;

	@Persist
	@Property
	private String message;

	Object onActivate(Long id) {
		programme = programmeDAO.findByID(id);
		if (programme == null) {
			errorPage.setMessage("Mistake! ");
			return errorPage;
		}
		return null;
	}

	Object onSuccess() {
		error = "";
		message = "";
		if ((programme.getName() == "" || programme.getName() == null)) {
			error = "You must provide value for every field!";
		} else {
			programmeDAO.update(programme);
			message = "Programme successfully updated!";

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
