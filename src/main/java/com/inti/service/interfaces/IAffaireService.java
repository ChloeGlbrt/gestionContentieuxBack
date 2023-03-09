package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Affaire;

public interface IAffaireService {
	
	List<Affaire> findAll();

	Affaire findOne(Long id);

	Affaire save(Affaire affaire);

	void delete(Long id);

}
