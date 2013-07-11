package com.fit.ossa.pages.programme;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.programme.ProgrammeDAO;
import com.fit.ossa.entities.programme.Programme;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class DetailProgramme {

	@Property
	@Persist
	private Programme programme;
	@Inject
	private ProgrammeDAO programmeDAO;
	@InjectPage
	private ErrorPage errorPage;

	Object onActivate(Long id) {
		programme = programmeDAO.findByID(id);
		if (programme == null) {
			errorPage.setMessage("Mistake! ");
			return errorPage;
		}
		return null;

	}

}
