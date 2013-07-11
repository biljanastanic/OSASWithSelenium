package com.fit.ossa.pages.links;

import java.util.List;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.links.LinksDAO;
import com.fit.ossa.entities.enroll.EnrollUFP;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class ShowLinks {

	@Property
	private List<EnrollUFP> enrolls;
	@Property
	private EnrollUFP enrollUFP;
	@Inject
	private LinksDAO linksDAO;
	@InjectPage
	private ErrorPage errorPage;

	void onActivate() {
		enrolls = linksDAO.findAll();
	}

	@OnEvent(component = "deleteLink")
	Object onDeleteLink(Long id) {
		try {
			linksDAO.deleteByID(id);
			return null;
		} catch (Exception e) {
			errorPage.setMessage("Mistake!");
			return errorPage;
		}
	}

}
