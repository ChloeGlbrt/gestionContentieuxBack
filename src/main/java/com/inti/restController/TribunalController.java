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

import com.inti.entities.Tribunal;
import com.inti.service.interfaces.ITribunalService;

@RestController
@CrossOrigin
public class TribunalController {

	@Autowired
	ITribunalService tribunalService;

	@GetMapping("/tribunaux")
	public List<Tribunal> findAll() {
		return tribunalService.findAll();
	}

	@GetMapping("tribunaux/{idTribunal}")
	public Tribunal findOne(@PathVariable("idTribunal") Long id) {
		return tribunalService.findOne(id);
	}

	@PostMapping("/tribunaux")
	public Tribunal save(@RequestBody Tribunal tribunal) {
		return tribunalService.save(tribunal);
	}

	@DeleteMapping("/tribunaux/{idTribunal}")
	public void delete(@PathVariable("idTribunal") Long id) {
		tribunalService.delete(id);
	}

	@PutMapping("/tribunaux/{idTribunal}")
	public Tribunal updateTribunalWithPut(@PathVariable("idTribunal") Long id, @RequestBody Tribunal tribunal) {
		Tribunal currentTribunal = tribunalService.findOne(id);
		currentTribunal.setAdresse(tribunal.getAdresse());
		currentTribunal.setFax(tribunal.getFax());
		currentTribunal.setRegion(tribunal.getRegion());
		currentTribunal.setTel(tribunal.getTel());
		return tribunalService.save(currentTribunal);

	}

	@PatchMapping("/tribunaux/{idTribunal}")
	public Tribunal updateTribunalWithPatch(@PathVariable("idTribunal") Long id, @RequestBody Tribunal tribunal) {
		Tribunal currentTribunal = tribunalService.findOne(id);
		return tribunalService.save(currentTribunal);
	}

}
