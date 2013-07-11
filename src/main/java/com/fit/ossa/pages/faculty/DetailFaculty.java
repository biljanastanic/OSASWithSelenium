package com.fit.ossa.pages.faculty;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.faculty.FacultyDAO;
import com.fit.ossa.entities.faculty.Faculty;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class DetailFaculty {

	@Property
	@Persist
	private Faculty faculty;
	@Inject
	private FacultyDAO facultyDAO;
	@InjectPage
	private ErrorPage errorPage;

	Object onActivate(Long id) {
		faculty = facultyDAO.findByID(id);
		if (faculty == null) {
			errorPage.setMessage("Mistake! ");
			return errorPage;
		}
		return null;

	}

}
