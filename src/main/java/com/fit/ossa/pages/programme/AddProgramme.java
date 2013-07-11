package com.fit.ossa.pages.programme;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.programme.ProgrammeDAO;
import com.fit.ossa.entities.programme.Programme;

@AdminAccess
public class AddProgramme {
	@Property
	@SessionState(create = false)
	private Programme programme;

	@Inject
	private ProgrammeDAO programmeDAO;

	@Component
	private Form createForm;

	@Persist
	@Property
	private String error;

	@Persist
	@Property
	private String message;

	void onPrepare() {
		programme = new Programme();
	}

	Object onSubmitFromCreateForm() {
		error = "";
		message = "";
		if ((programme.getName() == "" || programme.getName() == null)) {
			error = "You must provide value for every field!";
		} else {
			programmeDAO.save(programme);
			message = "Programme successfully added!";

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
