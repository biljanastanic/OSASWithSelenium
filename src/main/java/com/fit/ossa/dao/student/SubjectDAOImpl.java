package com.fit.ossa.dao.student;

import java.util.List;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fit.ossa.entities.subject.Subject;

public class SubjectDAOImpl implements SubjectDAO {

	@Inject
	private Session session;

	@Log
	public boolean save(Subject newSubject) {
		if (newSubject != null) {
			session.save(newSubject);
			return true;
		}
		return false;
	}

	@Log
	public boolean delete(Subject subject) {
		if (subject != null) {
			session.delete(subject);
			return true;
		}
		return false;
	}

	@Log
	public boolean update(Subject subject) {
		if (subject != null) {
			session.update(subject);
			return true;
		}
		return false;
	}

	@Log
	public List findAll() {
		return session.createCriteria(Subject.class).list();
	}

	@Log
	public boolean deleteByID(Long id) {
		Subject f = findByID(id);
		if (f != null) {
			delete(f);
			return true;
		}
		return false;
	}

	@Log
	public Subject findByID(Long id) {
		if (id != null) {
			return (Subject) session.get(Subject.class, id);
		}
		return null;
	}

	@Log
	public Subject findBySubjectName(String name) {
		if (name == null) {
			return null;
		}

		if (name.equals("")) {
			return null;
		}

		List l = session.createCriteria(Subject.class)
				.add(Restrictions.eq("name", name)).list();
		Subject u = null;
		if (l != null) {
			if (l.size() > 0) {
				u = (Subject) l.get(0);
			}
		}
		return u;
	}

}
