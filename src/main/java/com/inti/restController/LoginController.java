package com.inti.restController;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	IUtilisateurService utilisateurService;

	@CrossOrigin
	@RequestMapping(value = "/utilisateur")
	public Utilisateur login(Principal principal) {
		return utilisateurService.findByUsername(principal.getName());
	}
}