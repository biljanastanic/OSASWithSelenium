package com.fit.ossa.pages.links;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.fit.ossa.annotations.AdminAccess;
import com.fit.ossa.dao.links.LinksDAO;
import com.fit.ossa.entities.enroll.EnrollUFP;
import com.fit.ossa.pages.ErrorPage;

@AdminAccess
public class DetailLinks {

	@Property
	@Persist
	private EnrollUFP enrollUFP;
	@Inject
	private LinksDAO linksDAO;
	@InjectPage
	private ErrorPage errorPage;

	Object onActivate(Long id) {
		enrollUFP = linksDAO.findByID(id);
		if (enrollUFP == null) {
			errorPage.setMessage("Mistake! ");
			return errorPage;
		}
		return null;

	}

}
