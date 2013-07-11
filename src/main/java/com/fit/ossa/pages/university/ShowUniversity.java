package com.fit.ossa.pages.university;

import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.univesity.UniversityDAO;
import com.fit.ossa.entities.univesity.University;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class ShowUniversity {

	@Property
	private List<University> universities;
	@Property
	private University university;
	@Inject
	private UniversityDAO universityDAO;
	@InjectPage
	private ErrorPage errorPage;

	void onActivate() {
		universities = universityDAO.findAll();
	}

	@OnEvent(component = "deleteLink")
	Object onDeleteLink(Long id) {
		try {
			universityDAO.deleteByID(id);
			return null;
		} catch (Exception e) {
			errorPage.setMessage("Mistake!");
			return errorPage;
		}
	}

}
