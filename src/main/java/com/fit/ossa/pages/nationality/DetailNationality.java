package com.fit.ossa.pages.nationality;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.nationality.NationalityDAO;
import com.fit.ossa.entities.nationality.Nationality;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class DetailNationality {

	@Property
	@Persist
	private Nationality nationality;
	@Inject
	private NationalityDAO nationalityDAO;
	@InjectPage
	private ErrorPage errorPage;

	Object onActivate(Long id) {
		nationality = nationalityDAO.findByID(id);
		if (nationality == null) {
			errorPage.setMessage("Mistake! ");
			return errorPage;
		}
		return null;

	}

}
