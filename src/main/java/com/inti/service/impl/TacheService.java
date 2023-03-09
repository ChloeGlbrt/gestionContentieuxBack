package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Tache;
import com.inti.repositories.TacheRepository;
import com.inti.service.interfaces.ITacheService;

@Service
public class TacheService implements ITacheService {

	@Autowired
	TacheRepository tacheRepository;

	@Override
	public List<Tache> findAll() {
		return tacheRepository.findAll();
	}
	
	@Override
	public Tache findByIdUser(Long idTache) {
		return tacheRepository.findByIdUser(idTache);
	}
	
	@Override
	public Tache save(Tache tache) {
		return tacheRepository.save(tache);
	}
	
	

	@Override
	public void delete(Long idTache) {
		tacheRepository.deleteById(idTache);

	}

	@Override
	public Tache findOne(Long idTache) {
		// TODO Auto-generated method stub
		return tacheRepository.findById(idTache).get();
	}
}
