package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Tache;

public interface ITacheService {

	public List<Tache> findAll();

	Tache findByIdUser(Long idTache);

	Tache save(Tache tache);

	Tache findOne(Long idTache);

	void delete(Long idTache);

}
