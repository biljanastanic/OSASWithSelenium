package com.fit.ossa.pages.faculty;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.faculty.FacultyDAO;
import com.fit.ossa.entities.faculty.Faculty;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class EditFaculty {

	@Property
	@Persist
	private Faculty faculty;
	@Inject
	private FacultyDAO facultyDAO;
	@InjectPage
	private ErrorPage errorPage;
	@Persist
	@Property
	private String error;

	@Persist
	@Property
	private String message;

	Object onActivate(Long id) {
		faculty = facultyDAO.findByID(id);
		if (faculty == null) {
			errorPage.setMessage("Mistake! ");
			return errorPage;
		}
		return null;
	}

	Object onSuccess() {
		error = "";
		message = "";
		if ((faculty.getName() == "" || faculty.getName() == null)
				|| (faculty.getAbbreviation() == "" || faculty
						.getAbbreviation() == null)) {
			error = "You must provide value for every field!";
		} else {
			facultyDAO.update(faculty);
			message = "Faculty successfully updated!";

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
