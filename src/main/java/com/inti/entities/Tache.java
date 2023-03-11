package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "TACHES", schema = "gestion_contentieux")
public class Tache implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTache;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private String titre;
	private String description;
	private boolean statutAudience;
	
	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateurFK;
	
	@ManyToOne
	@JoinColumn(name = "idAffaire")
	private Affaire affaireFK;
	
	@ManyToOne
	@JoinColumn(name = "idTribunal")
	private Tribunal tribunalFK;
	
	@OneToMany(mappedBy = "tacheFK")
	@Transient
	private List<Phase> phases = new ArrayList<>();

	public Tache() {
	}

	public Tache(Date dateCreation, String titre, String description, boolean statutAudience,
			Utilisateur utilisateurFK) {
		this.dateCreation = dateCreation;
		this.titre = titre;
		this.description = description;
		this.statutAudience = statutAudience;
		this.utilisateurFK = utilisateurFK;
	}

	public Tache(Date dateCreation, String titre, String description, boolean statutAudience, Utilisateur utilisateurFK,
			Affaire affaireFK) {
		this.dateCreation = dateCreation;
		this.titre = titre;
		this.description = description;
		this.statutAudience = statutAudience;
		this.utilisateurFK = utilisateurFK;
		this.affaireFK = affaireFK;
	}

	public Tache(Date dateCreation, String titre, String description, boolean statutAudience, Utilisateur utilisateurFK,
			Affaire affaireFK, Tribunal tribunalFK) {
		this.dateCreation = dateCreation;
		this.titre = titre;
		this.description = description;
		this.statutAudience = statutAudience;
		this.utilisateurFK = utilisateurFK;
		this.affaireFK = affaireFK;
		this.tribunalFK = tribunalFK;
	}

	public Tache(Date dateCreation, String titre, String description, boolean statutAudience, Utilisateur utilisateurFK,
			Affaire affaireFK, Tribunal tribunalFK, List<Phase> phases) {
		this.dateCreation = dateCreation;
		this.titre = titre;
		this.description = description;
		this.statutAudience = statutAudience;
		this.utilisateurFK = utilisateurFK;
		this.affaireFK = affaireFK;
		this.tribunalFK = tribunalFK;
		this.phases = phases;
	}

	public long getIdTache() {
		return idTache;
	}

	public void setIdTache(long idTache) {
		this.idTache = idTache;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
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

	public boolean isStatutAudience() {
		return statutAudience;
	}

	public void setStatutAudience(boolean statutAudience) {
		this.statutAudience = statutAudience;
	}

	public Utilisateur getUtilisateurFK() {
		return utilisateurFK;
	}

	public void setUtilisateurFK(Utilisateur utilisateurFK) {
		this.utilisateurFK = utilisateurFK;
	}

	public Affaire getAffaireFK() {
		return affaireFK;
	}

	public void setAffaireFK(Affaire affaireFK) {
		this.affaireFK = affaireFK;
	}

	public Tribunal getTribunalFK() {
		return tribunalFK;
	}

	public void setTribunalFK(Tribunal tribunalFK) {
		this.tribunalFK = tribunalFK;
	}

	public List<Phase> getPhases() {
		return phases;
	}

	public void setPhases(List<Phase> phases) {
		this.phases = phases;
	}

	@Override
	public String toString() {
		return "Tache [idTache=" + idTache + ", dateCreation=" + dateCreation + ", titre=" + titre + ", description="
				+ description + ", statutAudience=" + statutAudience + ", utilisateurFK=" + utilisateurFK
				+ ", affaireFK=" + affaireFK + ", tribunalFK=" + tribunalFK + "]";
	}


}
