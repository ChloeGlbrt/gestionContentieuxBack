package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "AFFAIRES", schema = "gestion_contentieux")
public class Affaire implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAffaire;

	private String reference;
	private String titre;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date dateAffaire;
	private int statut;

	@OneToMany(mappedBy = "affaireFK")
	@Transient
	private List<Document> documents = new ArrayList<>();

	@OneToMany(mappedBy = "affaireFK")
	@Transient
	private List<Tache> taches = new ArrayList<>();

	public Affaire() {

	}


	public Affaire(String reference, String titre, String description, Date dateAffaire, int statut) {
		this.reference = reference;
		this.titre = titre;
		this.description = description;
		this.dateAffaire = dateAffaire;
		this.statut = statut;
	}


	public Affaire(Long idAffaire, String reference, String titre, String description, Date dateAffaire, int statut,
			List<Document> documents) {
		this.idAffaire = idAffaire;
		this.reference = reference;
		this.titre = titre;
		this.description = description;
		this.dateAffaire = dateAffaire;
		this.statut = statut;
		this.documents = documents;
	}

	public Affaire(String reference, String titre, String description, Date dateAffaire, int statut,
			List<Document> documents, List<Tache> taches) {
		this.reference = reference;
		this.titre = titre;
		this.description = description;
		this.dateAffaire = dateAffaire;
		this.statut = statut;
		this.documents = documents;
		this.taches = taches;
	}


	public Long getIdAffaire() {
		return idAffaire;
	}

	public void setIdAffaire(Long idAffaire) {
		this.idAffaire = idAffaire;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	
	
	public Date getDateAffaire() {
		return dateAffaire;
	}


	public void setDateAffaire(Date dateAffaire) {
		this.dateAffaire = dateAffaire;
	}


	@Override
	public String toString() {
		return "Affaire [idAffaire=" + idAffaire + ", reference=" + reference + ", titre=" + titre + ", description="
				+ description + ", dateAffaire=" + dateAffaire + ", statut=" + statut + "]";
	}

}
