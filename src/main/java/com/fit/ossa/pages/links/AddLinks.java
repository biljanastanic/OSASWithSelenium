package com.fit.ossa.pages.links;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.services.PropertyAccess;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.faculty.FacultyDAO;
import com.fit.ossa.dao.links.LinksDAO;
import com.fit.ossa.dao.programme.ProgrammeDAO;
import com.fit.ossa.dao.univesity.UniversityDAO;
import com.fit.ossa.entities.enroll.EnrollUFP;
import com.fit.ossa.entities.faculty.Faculty;
import com.fit.ossa.entities.programme.Programme;
import com.fit.ossa.entities.univesity.University;
import com.fit.ossa.model.gsm.GenericSelectModel;

@AdminAccess
public class AddLinks {
	@Property
	@SessionState(create = false)
	private EnrollUFP enrollUFP;

	@Inject
	private LinksDAO linksDAO;

	@Property
	private University university;

	@Inject
	private UniversityDAO universityDAO;

	@Property
	private Faculty faculty;

	@Inject
	private FacultyDAO facultyDAO;

	@Property
	private Programme programme;

	@Inject
	private ProgrammeDAO programmeDAO;

	@Component
	private Form createForm;

	@Inject
	private PropertyAccess access;

	@Persist
	@Property
	private String error;

	@Persist
	@Property
	private String message;

	private GenericSelectModel<University> universities;
	private GenericSelectModel<Faculty> faculties;
	private GenericSelectModel<Programme> programmes;

	void onPrepare() {
		enrollUFP = new EnrollUFP();
	}

	public GenericSelectModel<University> getUniversities() {
		universities = new GenericSelectModel<University>(
				universityDAO.findAll(), University.class, "name", "id", access);
		return universities;
	}

	public GenericSelectModel<Faculty> getFaculties() {
		faculties = new GenericSelectModel<Faculty>(facultyDAO.findAll(),
				Faculty.class, "name", "id", access);
		return faculties;
	}

	public GenericSelectModel<Programme> getProgrammes() {
		programmes = new GenericSelectModel<Programme>(programmeDAO.findAll(),
				Programme.class, "name", "id", access);
		return programmes;
	}

	Object onSubmitFromCreateForm() {
		error = "";
		message = "";
		if (faculty == null || university == null || programme == null) {
			error = "You must provide value for every field!";
		} else {
			enrollUFP.setUniversity(university);
			enrollUFP.setFaculty(faculty);
			enrollUFP.setProgramme(programme);
			linksDAO.save(enrollUFP);
			message = "Links successfully added!";
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
