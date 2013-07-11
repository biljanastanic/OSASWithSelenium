package com.fit.ossa.dao.user;

import java.util.List;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.fit.ossa.entities.user.User;



public class UserDAOImpl implements UserDAO{
	
	@Inject
	private Session session;

	@Log
	public boolean save(User newUser) {
		if (newUser != null) {
			session.save(newUser);
			return true;
		}
		return false;
	}

	@Log
	public boolean delete(User user) {
		if (user != null) {
			session.delete(user);
			return true;
		}
		return false;
	}

	@Log
	public boolean update(User user) {
		if (user != null) {
			session.update(user);
			return true;
		}
		return false;
	}

	@Log
	public List findAll() {
		return session.createCriteria(User.class).list();
	}

	@Log
	public boolean deleteByID(Long id) {
		User u = findByID(id);
		if (u != null) {
			delete(u);
			return true;
		}
		return false;
	}

	@Log
	public User findByID(Long id) {
		if (id != null) {
			return (User) session.get(User.class, id);
		}
		return null;
	}

	@Log
	public User findByUserNameAndPassword(String username, String password) {
		if (password == null || username == null) {
			return null;
		}

		if (password.equals("") || username.equals("")) {
			return null;
		}

		List l = session.createCriteria(User.class)
				.add(Restrictions.eq("username", username))
				.add(Restrictions.eq("password", password)).list();
		User u = null;
		if (l != null) {
			if (l.size() > 0) {
				u = (User) l.get(0);
			}
		}
		return u;
	}

}
