package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRIBUNAL", schema ="gestion_contentieux")
public class Tribunal implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTribunal;
	private String adresse;
	private String fax;
	private String tel;
	private String region;
	
/*@OneToMany (mappedBy = "tribunalFK")
 * @Transient
 *private List<Tache> taches = new ArrayList<>(); 
 * 
 * */
	
	public Tribunal() {}


	public Tribunal(String adresse, String fax, String tel, String region) {
		this.adresse = adresse;
		this.fax = fax;
		this.tel = tel;
		this.region = region;
	}
	
	/*public Tribunal(String adresse, String fax, String tel, String region, List<Tache> taches) {
		this.adresse = adresse;
		this.fax = fax;
		this.tel = tel;
		this.region = region;
		this.taches = taches;
	 * 
	 * 
	 */
	

	public Long getIdTribunal() {
		return idTribunal;
	}


	public void setIdTribunal(Long idTribunal) {
		this.idTribunal = idTribunal;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}
	
	/*
	 * 
	 * public List <Tache> getTaches(){
	 * return taches;
	 * }
	 * 
	 *
	 * public void setTaches (List<Tache> taches) {
	 * this.taches = taches;
	 * 
	 * }
	 * 
	 * 
	 * */
	
	
// Modifier la méthode toString avec Tache
	@Override
	public String toString() {
		return "Tribunal [idTribunal=" + idTribunal + ", adresse=" + adresse + ", fax=" + fax + ", tel=" + tel
				+ ", region=" + region + "]";
	}

	
	
}
