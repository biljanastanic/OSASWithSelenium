package com.fit.ossa.dao.programme;

import java.util.List;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fit.ossa.entities.programme.Programme;

public class ProgrammeDAOImpl implements ProgrammeDAO {

	@Inject
	private Session session;

	@Log
	public boolean save(Programme newProgramme) {
		if (newProgramme != null) {
			session.save(newProgramme);
			return true;
		}
		return false;
	}

	@Log
	public boolean delete(Programme programme) {
		if (programme != null) {
			session.delete(programme);
			return true;
		}
		return false;
	}

	@Log
	public boolean update(Programme programme) {
		if (programme != null) {
			session.update(programme);
			return true;
		}
		return false;
	}

	@Log
	public List findAll() {
		return session.createCriteria(Programme.class).list();
	}

	@Log
	public boolean deleteByID(Long id) {
		Programme f = findByID(id);
		if (f != null) {
			delete(f);
			return true;
		}
		return false;
	}

	@Log
	public Programme findByID(Long id) {
		if (id != null) {
			return (Programme) session.get(Programme.class, id);
		}
		return null;
	}

	@Log
	public Programme findByProgrammeName(String name) {
		if (name == null) {
			return null;
		}

		if (name.equals("")) {
			return null;
		}

		List l = session.createCriteria(Programme.class)
				.add(Restrictions.eq("name", name)).list();
		Programme u = null;
		if (l != null) {
			if (l.size() > 0) {
				u = (Programme) l.get(0);
			}
		}
		return u;
	}

}
