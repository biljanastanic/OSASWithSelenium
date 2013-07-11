package com.fit.ossa.entities.enroll;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.tapestry5.beaneditor.NonVisual;
import com.fit.ossa.entities.faculty.Faculty;
import com.fit.ossa.entities.programme.Programme;
import com.fit.ossa.entities.subject.Subject;
import com.fit.ossa.entities.univesity.University;

@Entity
@Table(name = "enroll_ufps")
public class EnrollUFPSubject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	@Column(name = "enroll_ufps_id")
	private Long id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "enroll_ufps_fk_university")
	private University university;
	@ManyToOne(optional = false)
	@JoinColumn(name = "enroll_ufps_fk_faculty")
	private Faculty faculty;
	@ManyToOne(optional = false)
	@JoinColumn(name = "enroll_ufps_fk_programme")
	private Programme programme;
	@ManyToMany
	@JoinTable(name = "enroll_ufps_subject", joinColumns = { @JoinColumn(name = "enroll_ufps_id") }, inverseJoinColumns = { @JoinColumn(name = "subject_id") })
	private List<Subject> products = new ArrayList<Subject>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Programme getProgramme() {
		return programme;
	}

	public void setProgramme(Programme programme) {
		this.programme = programme;
	}

	public List<Subject> getProducts() {
		return products;
	}

	public void setProducts(List<Subject> products) {
		this.products = products;
	}

}
