package com.fit.ossa.pages.programme;

import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.programme.ProgrammeDAO;
import com.fit.ossa.entities.programme.Programme;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class ShowProgramme {

	@Property
	private List<Programme> programmes;
	@Property
	private Programme programme;
	@Inject
	private ProgrammeDAO programmeDAO;
	@InjectPage
	private ErrorPage errorPage;

	void onActivate() {
		programmes = programmeDAO.findAll();
	}

	@OnEvent(component = "deleteLink")
	Object onDeleteLink(Long id) {
		try {
			programmeDAO.deleteByID(id);
			return null;
		} catch (Exception e) {
			errorPage.setMessage("Mistake!");
			return errorPage;
		}
	}

}
