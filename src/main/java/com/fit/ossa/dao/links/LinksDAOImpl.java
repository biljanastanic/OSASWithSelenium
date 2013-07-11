package com.fit.ossa.dao.links;

import java.util.List;

import javax.print.attribute.standard.MediaSize.NA;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fit.ossa.entities.enroll.EnrollUFP;
import com.fit.ossa.entities.faculty.Faculty;

public class LinksDAOImpl implements LinksDAO {

	@Inject
	private Session session;

	@Log
	public boolean save(EnrollUFP enrollUFP) {
		if (enrollUFP != null) {
			session.save(enrollUFP);
			return true;
		}
		return false;
	}

	@Log
	public boolean delete(EnrollUFP enrollUFP) {
		if (enrollUFP != null) {
			session.delete(enrollUFP);
			return true;
		}
		return false;
	}

	@Log
	public boolean update(EnrollUFP enrollUFP) {
		if (enrollUFP != null) {
			session.update(enrollUFP);
			return true;
		}
		return false;
	}

	@Log
	public List findAll() {
		return session.createCriteria(EnrollUFP.class).list();
	}

	@Log
	public boolean deleteByID(Long id) {
		EnrollUFP f = findByID(id);
		if (f != null) {
			delete(f);
			return true;
		}
		return false;
	}

	@Log
	public EnrollUFP findByID(Long id) {
		if (id != null) {
			return (EnrollUFP) session.get(EnrollUFP.class, id);
		}
		return null;
	}

	@Log
	public EnrollUFP findByEnrollUFPByFaculty(Faculty faculty) {
		if (faculty.getName() == null) {
			return null;
		}

		if (faculty.getName().equals("")) {
			return null;
		}

		List l = session.createCriteria(EnrollUFP.class)
				.add(Restrictions.eq("faculty.name", faculty.getName())).list();
		EnrollUFP u = null;
		if (l != null) {
			if (l.size() > 0) {
				u = (EnrollUFP) l.get(0);
			}
		}
		return u;
	}

}
