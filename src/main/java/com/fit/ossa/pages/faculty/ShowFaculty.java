package com.fit.ossa.pages.faculty;

import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.faculty.FacultyDAO;
import com.fit.ossa.entities.faculty.Faculty;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class ShowFaculty {

	@Property
	private List<Faculty> faculties;
	@Property
	private Faculty faculty;
	@Inject
	private FacultyDAO facultyDAO;
	@InjectPage
	private ErrorPage errorPage;

	void onActivate() {
		faculties = facultyDAO.findAll();
	}

	@OnEvent(component = "deleteLink")
	Object onDeleteLink(Long id) {
		try {
			facultyDAO.deleteByID(id);
			return null;
		} catch (Exception e) {
			errorPage.setMessage("Mistake!");
			return errorPage;
		}
	}

}
