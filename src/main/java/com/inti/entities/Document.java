package com.inti.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "DOCUMENTS", schema = "gestion_contentieux")
public class Document implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocument;

	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private String nom;
	private String description;

	@ManyToOne
	@JoinColumn(name = "id_affaire")
	private Affaire affaireFK;

	public Document() {

	}

	public Document(Date dateCreation, String nom, String description) {
		this.dateCreation = dateCreation;
		this.nom = nom;
		this.description = description;
	}

	public Document(Date dateCreation, String nom, String description, Affaire affaireFK) {
		this.dateCreation = dateCreation;
		this.nom = nom;
		this.description = description;
		this.affaireFK = affaireFK;
	}

	public Long getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Affaire getAffaireFK() {
		return affaireFK;
	}

	public void setAffaireFK(Affaire affaireFK) {
		this.affaireFK = affaireFK;
	}

	@Override
	public String toString() {
		return "Document [idDocument=" + idDocument + ", dateCreation=" + dateCreation + ", nom=" + nom
				+ ", description=" + description + ", affaireFK=" + affaireFK + "]";
	}

}
