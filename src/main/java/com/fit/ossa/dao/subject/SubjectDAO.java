package com.fit.ossa.dao.subject;

import java.util.List;

import org.apache.tapestry5.hibernate.annotations.CommitAfter;

import com.fit.ossa.entities.subject.Subject;

public interface SubjectDAO {

	@CommitAfter
	public boolean save(Subject newSubject);

	@CommitAfter
	public boolean delete(Subject subject);

	@CommitAfter
	public boolean update(Subject subject);

	public List<Subject> findAll();

	public Subject findBySubjectName(String name);

	public Subject findByID(Long id);

	@CommitAfter
	public boolean deleteByID(Long id);

}
