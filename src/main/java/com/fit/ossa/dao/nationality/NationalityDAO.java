package com.fit.ossa.dao.nationality;

import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.fit.ossa.entities.nationality.Nationality;

public interface NationalityDAO {

	@CommitAfter
	public boolean save(Nationality newNationality);

	@CommitAfter
	public boolean delete(Nationality nationality);

	@CommitAfter
	public boolean update(Nationality nationality);

	public List<Nationality> findAll();

	public Nationality findByNationalityName(String name);

	public Nationality findByID(Long id);

	@CommitAfter
	public boolean deleteByID(Long id);

}
