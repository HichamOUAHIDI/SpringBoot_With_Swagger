package org.ms.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ContactMap {
	
	private Long id; 
	private String nomContact; 
	private String prenom; 
	private Date dateNaissnace; 
	private String email; 
	private long tel; 
	private String photo;
	
	public ContactMap(Long id, String nomContact, String prenom, Date dateNaissnace, String email, long tel,
			String photo) {
		super();
		this.id = id;
		this.nomContact = nomContact;
		this.prenom = prenom;
		this.dateNaissnace = dateNaissnace;
		this.email = email;
		this.tel = tel;
		this.photo = photo;
	}

	public ContactMap() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomContact() {
		return nomContact;
	}

	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissnace() {
		return dateNaissnace;
	}

	public void setDateNaissnace(Date dateNaissnace) {
		this.dateNaissnace = dateNaissnace;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	

	
}
