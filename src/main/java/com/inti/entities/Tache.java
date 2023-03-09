package com.inti.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TACHES", schema = "gestion_contentieux")
public class Tache {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTache;
	private Date dateCreation;
	private String titre;
	private String description;
	private boolean statutAudience;
	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur_fk;
	@ManyToOne
	@JoinColumn(name = "idAffaire")
	private Affaire affaire_fk;
	@ManyToOne
	@JoinColumn(name = "idTribunal")
	private Tribunal tribunal_fk;
    @OneToMany( mappedBy="tache" )
    private List<Phase> phases = new ArrayList<>();

    
    public Tache() {
	}


	public Tache(Date dateCreation, String titre, String description, boolean statutAudience,
			Utilisateur utilisateur_fk, Affaire affaire_fk, Tribunal tribunal_fk, List<Phase> phases) {
		super();
		this.dateCreation = dateCreation;
		this.titre = titre;
		this.description = description;
		this.statutAudience = statutAudience;
		this.utilisateur_fk = utilisateur_fk;
		this.affaire_fk = affaire_fk;
		this.tribunal_fk = tribunal_fk;
		this.phases = phases;
	}


	public Tache(Date dateCreation, String titre, String description, boolean statutAudience,
			Utilisateur utilisateur_fk, Affaire affaire_fk, Tribunal tribunal_fk) {
		super();
		this.dateCreation = dateCreation;
		this.titre = titre;
		this.description = description;
		this.statutAudience = statutAudience;
		this.utilisateur_fk = utilisateur_fk;
		this.affaire_fk = affaire_fk;
		this.tribunal_fk = tribunal_fk;
	}


	public Tache(Date dateCreation, String titre, String description, boolean statutAudience) {
		super();
		this.dateCreation = dateCreation;
		this.titre = titre;
		this.description = description;
		this.statutAudience = statutAudience;
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


	public Utilisateur getUtilisateur_fk() {
		return utilisateur_fk;
	}


	public void setUtilisateur_fk(Utilisateur utilisateur_fk) {
		this.utilisateur_fk = utilisateur_fk;
	}


	public Affaire getAffaire_fk() {
		return affaire_fk;
	}


	public void setAffaire_fk(Affaire affaire_fk) {
		this.affaire_fk = affaire_fk;
	}


	public Tribunal getTribunal_fk() {
		return tribunal_fk;
	}


	public void setTribunal_fk(Tribunal tribunal_fk) {
		this.tribunal_fk = tribunal_fk;
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
				+ description + ", statutAudience=" + statutAudience + ", utilisateur_fk=" + utilisateur_fk + "]";
	}
    
    
    
	

	

}
