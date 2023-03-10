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
	

	@GetMapping("/taches") 
	public List<Tache> findAll() {
		return tacheService.findAll();
	}

	@GetMapping("/taches/{idTache}") 
	public Tache findOne(@PathVariable("idTache") Long idTache) {
		return tacheService.findOne(idTache);
	}

	@PostMapping("/taches")
	public Tache save(@RequestBody Tache tache) {
		return tacheService.save(tache);
	}

	@DeleteMapping("/taches/{idTache}")
	public void delete(@PathVariable("idTache") Long idTache) {
		tacheService.delete(idTache);
	}

	@PutMapping("/taches/{idTache}")
	public Tache updateWithPut(@PathVariable("idTache") Long idTache, @RequestBody Tache tache) {
		Tache currentTache = tacheService.findOne(idTache);
		System.out.println(currentTache.toString());
		currentTache.setTitre(tache.getTitre());
		currentTache.setDescription(tache.getDescription());
		currentTache.setDateCreation(tache.getDateCreation());
		currentTache.setStatutAudience(tache.isStatutAudience());
		return tacheService.save(currentTache);
	}


}

