package com.fit.ossa.entities.student;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

import com.fit.ossa.entities.enroll.EnrollUFP;
import com.fit.ossa.entities.nationality.Nationality;
import com.fit.ossa.entities.univesity.University;
import com.fit.ossa.model.gender.GenderType;

@Entity
@Table(name = "profile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonVisual
	@Column(name = "profile_id")
	private Long id;
	@Validate("required")
	@Column(name = "fullname", nullable = false)
	private String fullname;
	@Validate("required")
	@Column(name = "date_of_birth", nullable = false)
	private Date dateOfBirth;
	@Validate("required")
	@Column(name = "gender", nullable = false)
	private GenderType gender;
	@Validate("required")
	@Column(name = "address", nullable = false)
	private String address;
	@Validate("required")
	@Column(name = "home_town", nullable = false)
	private String home_town;
	@Validate("required")
	@Column(name = "country", nullable = false)
	private String country;

	@ManyToOne(optional = false)
	@JoinColumn(name = "profile_nationality_id")
	private Nationality nationality;

	@Validate("required")
	@Column(name = "highschool", nullable = false)
	private String highschool;

	@Column(name = "records_src", nullable = false)
	private String RecordsSrc;
	@Column(name = "diploma_src")
	private String diplomaSrc;
	@Column(name = "presonalID_src", nullable = false)
	private String personalIDSrc;

	@OneToOne
	@JoinColumn(name = "profile_enroll_ufp_id")
	private EnrollUFP enrollUFP;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHome_town() {
		return home_town;
	}

	public void setHome_town(String home_town) {
		this.home_town = home_town;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHighschool() {
		return highschool;
	}

	public void setHighschool(String highschool) {
		this.highschool = highschool;
	}

	public String getRecordsSrc() {
		return RecordsSrc;
	}

	public void setRecordsSrc(String recordsSrc) {
		RecordsSrc = recordsSrc;
	}

	public String getDiplomaSrc() {
		return diplomaSrc;
	}

	public void setDiplomaSrc(String diplomaSrc) {
		this.diplomaSrc = diplomaSrc;
	}

	public String getPersonalIDSrc() {
		return personalIDSrc;
	}

	public void setPersonalIDSrc(String personalIDSrc) {
		this.personalIDSrc = personalIDSrc;
	}

	public EnrollUFP getEnrollUFP() {
		return enrollUFP;
	}

	public void setEnrollUFP(EnrollUFP enrollUFP) {
		this.enrollUFP = enrollUFP;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

}
