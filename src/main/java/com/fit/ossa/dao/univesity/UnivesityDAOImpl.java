package com.fit.ossa.dao.univesity;

import java.util.List;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fit.ossa.entities.univesity.University;

public class UnivesityDAOImpl implements UniversityDAO {

	@Inject
	private Session session;

	@Log
	public boolean save(University newUniversity) {
		if (newUniversity != null) {
			session.save(newUniversity);
			return true;
		}
		return false;
	}

	@Log
	public boolean delete(University university) {
		if (university != null) {
			session.delete(university);
			return true;
		}
		return false;
	}

	@Log
	public boolean update(University university) {
		if (university != null) {
			session.update(university);
			return true;
		}
		return false;
	}

	@Log
	public List findAll() {
		return session.createCriteria(University.class).list();
	}

	@Log
	public boolean deleteByID(Long id) {
		University u = findByID(id);
		if (u != null) {
			delete(u);
			return true;
		}
		return false;
	}

	@Log
	public University findByID(Long id) {
		if (id != null) {
			return (University) session.get(University.class, id);
		}
		return null;
	}

	@Log
	public University findByUniversityName(String name) {
		if (name == null) {
			return null;
		}

		if (name.equals("")) {
			return null;
		}

		List l = session.createCriteria(University.class)
				.add(Restrictions.eq("name", name)).list();
		University u = null;
		if (l != null) {
			if (l.size() > 0) {
				u = (University) l.get(0);
			}
		}
		return u;
	}



}
