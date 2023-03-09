package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Affaire;
import com.inti.service.interfaces.IAffaireService;

@RestController
@CrossOrigin
public class AffaireController {
	@Autowired
	IAffaireService affaireService;

	@GetMapping("/affaires")
	public List<Affaire> findAll() {
		return affaireService.findAll();
	}

	@GetMapping("/affaires/{idAffaire}")
	public Affaire findOne(@PathVariable("idAffaire") Long id) {
		return affaireService.findOne(id);
	}

	@PostMapping("/affaires")
	public Affaire saveAffaire(@RequestBody Affaire affaire) {
		return affaireService.save(affaire);
	}

	@DeleteMapping("/affaires/{idAffaire}")
	public void deleteAffaire(@PathVariable("idAffaire") Long id) {
		affaireService.delete(id);
	}
	
	@PutMapping("/affaires/{idAffaire}")
	public Affaire updateAffaireWithPut(@PathVariable("idAffaire") Long id,@RequestBody Affaire affaire) {
		Affaire currentAffaire = affaireService.findOne(id);
		currentAffaire.setDescription(affaire.getDescription());
		currentAffaire.setReference(affaire.getReference());
		currentAffaire.setStatut(affaire.getStatut());
		currentAffaire.setTitre(affaire.getTitre());
		return affaireService.save(currentAffaire);
	}
	
	@PatchMapping("/affaires/{idAffaire}")
	public Affaire updateAffaireWithPatch(@PathVariable("idAffaire") Long id,@RequestBody Affaire affaire) {
		Affaire currentAffaire = affaireService.findOne(id);
		currentAffaire.setDescription(affaire.getDescription());
		currentAffaire.setReference(affaire.getReference());
		currentAffaire.setStatut(affaire.getStatut());
		currentAffaire.setTitre(affaire.getTitre());
		return affaireService.save(currentAffaire);
	}
	
	
	
	
	
	
	
	
}
