package com.fit.ossa.dao.nationality;

import java.util.List;

import javax.print.attribute.standard.MediaSize.NA;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fit.ossa.entities.nationality.Nationality;

public class NationalityDAOImpl implements NationalityDAO {

	@Inject
	private Session session;

	@Log
	public boolean save(Nationality newNationality) {
		if (newNationality != null) {
			session.save(newNationality);
			return true;
		}
		return false;
	}

	@Log
	public boolean delete(Nationality nationality) {
		if (nationality != null) {
			session.delete(nationality);
			return true;
		}
		return false;
	}

	@Log
	public boolean update(Nationality nationality) {
		if (nationality != null) {
			session.update(nationality);
			return true;
		}
		return false;
	}

	@Log
	public List findAll() {
		return session.createCriteria(Nationality.class).list();
	}

	@Log
	public boolean deleteByID(Long id) {
		Nationality f = findByID(id);
		if (f != null) {
			delete(f);
			return true;
		}
		return false;
	}

	@Log
	public Nationality findByID(Long id) {
		if (id != null) {
			return (Nationality) session.get(Nationality.class, id);
		}
		return null;
	}

	@Log
	public Nationality findByNationalityName(String name) {
		if (name == null) {
			return null;
		}

		if (name.equals("")) {
			return null;
		}

		List l = session.createCriteria(Nationality.class)
				.add(Restrictions.eq("name", name)).list();
		Nationality u = null;
		if (l != null) {
			if (l.size() > 0) {
				u = (Nationality) l.get(0);
			}
		}
		return u;
	}

}
