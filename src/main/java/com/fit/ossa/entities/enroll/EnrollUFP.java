package com.fit.ossa.entities.enroll;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.tapestry5.beaneditor.NonVisual;

import com.fit.ossa.entities.faculty.Faculty;
import com.fit.ossa.entities.programme.Programme;
import com.fit.ossa.entities.univesity.University;

@Entity
@Table(name = "enroll_ufp")
public class EnrollUFP {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	@Column(name = "enroll_ufp_id")
	private Long id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "enroll_ufp_fk_university")
	private University university;
	@ManyToOne(optional = false)
	@JoinColumn(name = "enroll_ufp_fk_faculty")
	private Faculty faculty;
	@ManyToOne(optional = false)
	@JoinColumn(name = "enroll_ufp_fk_programme")
	private Programme programme;
	@Column(name = "photo_src", nullable = false)
	private String photoSrc;

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

	public String getPhotoSrc() {
		return photoSrc;
	}

	public void setPhotoSrc(String photoSrc) {
		this.photoSrc = photoSrc;
	}

}
