package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Utilisateur;
import com.inti.repositories.UtilisateurRepository;
import com.inti.service.interfaces.IUtilisateurService;

@Service
public class UtilisateurService implements IUtilisateurService {
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	public List<Utilisateur> findAll() {

		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findOne(Long id) {

		return utilisateurRepository.findById(id).get();
	}

	@Override
	public Utilisateur save(Utilisateur utilisateur) {

		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public void delete(Long id) {
		utilisateurRepository.deleteById(id);
	}

	@Override
	public Utilisateur findByUsername(String username) {

		return utilisateurRepository.findByUsername(username);
	}

}
