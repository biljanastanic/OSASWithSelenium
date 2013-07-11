package com.fit.ossa.dao.programme;

import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.fit.ossa.entities.programme.Programme;

public interface ProgrammeDAO {

	@CommitAfter
	public boolean save(Programme newProgramme);

	@CommitAfter
	public boolean delete(Programme programme);

	@CommitAfter
	public boolean update(Programme programme);

	public List<Programme> findAll();

	public Programme findByProgrammeName(String name);

	public Programme findByID(Long id);

	@CommitAfter
	public boolean deleteByID(Long id);

}
