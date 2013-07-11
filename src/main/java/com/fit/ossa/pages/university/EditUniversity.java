package com.fit.ossa.pages.university;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.univesity.UniversityDAO;
import com.fit.ossa.entities.univesity.University;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class EditUniversity {

	@Property
	@Persist
	private University university;
	@Inject
	private UniversityDAO universityDAO;
	@InjectPage
	private ErrorPage errorPage;
	@Persist
	@Property
	private String error;

	@Persist
	@Property
	private String message;

	Object onActivate(Long id) {
		university = universityDAO.findByID(id);
		if (university == null) {
			errorPage.setMessage("Mistake! ");
			return errorPage;
		}
		return null;
	}

	Object onSuccess() {
		error = "";
		message = "";
		if ((university.getName() == "" || university.getName() == null)
				|| (university.getAbbreviation() == "" || university
						.getAbbreviation() == null)) {
			error = "You must provide value for every field!";
		} else {
			universityDAO.update(university);
			message = "University successfully updated!";

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
