package com.inti.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Tache;
import com.inti.service.interfaces.ITacheService;

@RestController
@CrossOrigin 
public class TacheController {
	@Autowired
	ITacheService tacheService;
	

	@GetMapping("/Taches") 
	public List<Tache> findAll() {
		return tacheService.findAll();
	}

	@GetMapping("/Taches/{idTache}") 
	public Tache findOne(@PathVariable("idTache") Long idTache) {
		return tacheService.findOne(idTache);
	}

	@PostMapping("/Taches")
	public Tache save(@RequestBody Tache Tache) {
		return tacheService.save(Tache);
	}

	@DeleteMapping("/Taches/{idTache}")
	public void delete(@PathVariable("idTache") Long idTache) {
		tacheService.delete(idTache);
	}

	@PutMapping("/Taches/{idTache}")
	public Tache updateWithPut(@PathVariable("idTache") Long idTache, @RequestBody Tache Tache) {
		Tache currentTache = tacheService.findOne(idTache);
		System.out.println(currentTache.toString());
		currentTache.setTitre(Tache.getTitre());
		currentTache.setDescription(Tache.getDescription());
		currentTache.setDateCreation(Tache.getDateCreation());
		currentTache.setStatutAudience(Tache.isStatutAudience());
		return tacheService.save(currentTache);
	}


}

