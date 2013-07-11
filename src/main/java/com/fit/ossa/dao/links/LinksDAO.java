package com.fit.ossa.dao.links;

import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.fit.ossa.entities.enroll.EnrollUFP;
import com.fit.ossa.entities.faculty.Faculty;

public interface LinksDAO {

	@CommitAfter
	public boolean save(EnrollUFP newEnrollment);

	@CommitAfter
	public boolean delete(EnrollUFP enrollUFP);

	@CommitAfter
	public boolean update(EnrollUFP enrollUFP);

	public List<EnrollUFP> findAll();

	public EnrollUFP findByEnrollUFPByFaculty(Faculty faculty);

	public EnrollUFP findByID(Long id);

	@CommitAfter
	public boolean deleteByID(Long id);

}
