package com.fit.ossa.pages.university;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.univesity.UniversityDAO;
import com.fit.ossa.entities.univesity.University;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class DetailUniversity {

	@Property
	@Persist
	private University university;
	@Inject
	private UniversityDAO universityDAO;
	@InjectPage
	private ErrorPage errorPage;

	Object onActivate(Long id) {
		university = universityDAO.findByID(id);
		if (university == null) {
			errorPage.setMessage("Mistake! ");
			return errorPage;
		}
		return null;

	}

}
