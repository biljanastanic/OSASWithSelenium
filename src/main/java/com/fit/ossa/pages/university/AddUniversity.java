package com.fit.ossa.pages.university;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.univesity.UniversityDAO;
import com.fit.ossa.entities.univesity.University;

@AdminAccess
public class AddUniversity {
	@Property
	@SessionState(create = false)
	private University university;

	@Inject
	private UniversityDAO universityDAO;

	@Component
	private Form createForm;

	@Persist
	@Property
	private String error;

	@Persist
	@Property
	private String message;

	void onPrepare() {
		university = new University();
	}

	Object onSubmitFromCreateForm() {
		error = "";
		message = "";
		if ((university.getName() == "" || university.getName() == null)
				|| (university.getAbbreviation() == "" || university
						.getAbbreviation() == null)) {
			error = "You must provide value for every field!";
		} else {
			universityDAO.save(university);
			message = "University successfully added!";

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
