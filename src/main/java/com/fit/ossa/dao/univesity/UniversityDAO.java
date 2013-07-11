package com.fit.ossa.dao.univesity;

import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.fit.ossa.entities.univesity.University;

public interface UniversityDAO {

	@CommitAfter
	public boolean save(University newUnivesity);

	@CommitAfter
	public boolean delete(University university);

	@CommitAfter
	public boolean update(University university);

	public List<University> findAll();

	public University findByUniversityName(String name);

	public University findByID(Long id);

	@CommitAfter
	public boolean deleteByID(Long id);

}
