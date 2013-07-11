package com.fit.ossa.dao.faculty;

import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.fit.ossa.entities.faculty.Faculty;
import com.fit.ossa.entities.univesity.University;

public interface FacultyDAO {

	@CommitAfter
	public boolean save(Faculty newFaculty);

	@CommitAfter
	public boolean delete(Faculty faculty);

	@CommitAfter
	public boolean update(Faculty faculty);

	public List<Faculty> findAll();

	public Faculty findByFacultyName(String name);

	public Faculty findByID(Long id);

	@CommitAfter
	public boolean deleteByID(Long id);

}
