package com.fit.ossa.pages.faculty;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.faculty.FacultyDAO;
import com.fit.ossa.entities.faculty.Faculty;

@AdminAccess
public class AddFaculty {
	@Property
	@SessionState(create = false)
	private Faculty faculty;

	@Inject
	private FacultyDAO facultyDAO;

	@Component
	private Form createForm;

	@Persist
	@Property
	private String error;

	@Persist
	@Property
	private String message;

	void onPrepare() {
		faculty = new Faculty();
	}

	Object onSubmitFromCreateForm() {
		error = "";
		message = "";
		if ((faculty.getName() == "" || faculty.getName() == null)
				|| (faculty.getAbbreviation() == "" || faculty
						.getAbbreviation() == null)) {
			error = "You must provide value for every field!";
		} else {
			facultyDAO.save(faculty);
			message = "Faculty successfully added!";

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
