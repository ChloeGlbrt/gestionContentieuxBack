package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Utilisateur;

public interface IUtilisateurService {
	
	List<Utilisateur> findAll();
	
	Utilisateur findOne(Long id);
	
	Utilisateur save(Utilisateur utilisateur);
	
	void delete(Long id);
	
	Utilisateur findByUsername(String username);

}
