package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
	private int statut;

	@OneToMany(mappedBy = "affaireFK")
	@Transient
	private List<Document> documents = new ArrayList<>();

	@OneToMany(mappedBy = "affaireFK")
	@Transient
	private List<Tache> taches = new ArrayList<>();

	public Affaire() {

	}

	public Affaire(String reference, String titre, String description, int statut) {
		this.reference = reference;
		this.titre = titre;
		this.description = description;
		this.statut = statut;
	}

	public Affaire(String reference, String titre, String description, int statut, List<Document> documents) {
		this.reference = reference;
		this.titre = titre;
		this.description = description;
		this.statut = statut;
		this.documents = documents;
	}

	public Affaire(String reference, String titre, String description, int statut, List<Document> documents,
			List<Tache> taches) {
		this.reference = reference;
		this.titre = titre;
		this.description = description;
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

	@Override
	public String toString() {
		return "Affaire [idAffaire=" + idAffaire + ", reference=" + reference + ", titre=" + titre + ", description="
				+ description + ", statut=" + statut + "]";
	}

}
