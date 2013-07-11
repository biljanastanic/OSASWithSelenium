package com.fit.ossa.pages.nationality;

import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.nationality.NationalityDAO;
import com.fit.ossa.entities.nationality.Nationality;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class ShowNationality {

	@Property
	private List<Nationality> nationalities;
	@Property
	private Nationality nationality;
	@Inject
	private NationalityDAO nationalityDAO;
	@InjectPage
	private ErrorPage errorPage;

	void onActivate() {
		nationalities = nationalityDAO.findAll();
	}

	@OnEvent(component = "deleteLink")
	Object onDeleteLink(Long id) {
		try {
			nationalityDAO.deleteByID(id);
			return null;
		} catch (Exception e) {
			errorPage.setMessage("Mistake!");
			return errorPage;
		}
	}

}
