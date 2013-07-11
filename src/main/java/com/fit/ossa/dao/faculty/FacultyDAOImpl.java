package com.fit.ossa.dao.faculty;

import java.util.List;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fit.ossa.annotations.FacultyAccess;
import com.fit.ossa.entities.faculty.Faculty;
import com.fit.ossa.entities.univesity.University;

public class FacultyDAOImpl implements FacultyDAO {

	@Inject
	private Session session;

	@Log
	public boolean save(Faculty newFaculty) {
		if (newFaculty != null) {
			session.save(newFaculty);
			return true;
		}
		return false;
	}

	@Log
	public boolean delete(Faculty faculty) {
		if (faculty != null) {
			session.delete(faculty);
			return true;
		}
		return false;
	}

	@Log
	public boolean update(Faculty faculty) {
		if (faculty != null) {
			session.update(faculty);
			return true;
		}
		return false;
	}

	@Log
	public List findAll() {
		return session.createCriteria(Faculty.class).list();
	}

	@Log
	public boolean deleteByID(Long id) {
		Faculty f = findByID(id);
		if (f != null) {
			delete(f);
			return true;
		}
		return false;
	}

	@Log
	public Faculty findByID(Long id) {
		if (id != null) {
			return (Faculty) session.get(Faculty.class, id);
		}
		return null;
	}

	@Log
	public Faculty findByFacultyName(String name) {
		if (name == null) {
			return null;
		}

		if (name.equals("")) {
			return null;
		}

		List l = session.createCriteria(Faculty.class)
				.add(Restrictions.eq("name", name)).list();
		Faculty u = null;
		if (l != null) {
			if (l.size() > 0) {
				u = (Faculty) l.get(0);
			}
		}
		return u;
	}

}
