package com.inti.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inti.entities.Role;
import com.inti.entities.Utilisateur;
import com.inti.model.UtilisateurDetail;
import com.inti.service.interfaces.IUtilisateurService;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	IUtilisateurService utilisateurService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur = utilisateurService.findByUsername(username);
		// utilisateur : username = ouss, roles : {1 : admin, 3 : comptable}
		// profil : idUser : 1 idRole : 1 : admin
		// profil : idUser : 1 idRole : 3 : comptable
		// Récupération des profils
		// Les roles des utilisateurs
		Set<Role> roles = utilisateur.getRoles();
		// Les profils
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getLibelle()));
		}

		// Fin de Récupération des profils
		UtilisateurDetail utilisateurDetail = new UtilisateurDetail();
		utilisateurDetail.setUtilisateur(utilisateur);
		utilisateurDetail.setAuthorities(authorities); // les profils
		return utilisateurDetail; // objet qui stocke l'utilisateur et les profils
	}

}