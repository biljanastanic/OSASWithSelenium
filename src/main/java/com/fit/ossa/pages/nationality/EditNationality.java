package com.fit.ossa.pages.nationality;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.nationality.NationalityDAO;
import com.fit.ossa.entities.nationality.Nationality;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class EditNationality {

	@Property
	@Persist
	private Nationality nationality;
	@Inject
	private NationalityDAO nationalityDAO;
	@InjectPage
	private ErrorPage errorPage;
	@Persist
	@Property
	private String error;

	@Persist
	@Property
	private String message;

	Object onActivate(Long id) {
		nationality = nationalityDAO.findByID(id);
		if (nationality == null) {
			errorPage.setMessage("Mistake! ");
			return errorPage;
		}
		return null;
	}

	Object onSuccess() {
		error = "";
		message = "";
		if ((nationality.getName() == "" || nationality.getName() == null)) {
			error = "You must provide value for every field!";
		} else {
			nationalityDAO.update(nationality);
			message = "Nationality successfully updated!";

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
