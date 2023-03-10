package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Tribunal;
import com.inti.repositories.TribunalRepository;
import com.inti.service.interfaces.ITribunalService;

@Service
public class TribunalService implements ITribunalService {

	@Autowired
	TribunalRepository tribunalRepository;

	@Override
	public List<Tribunal> findAll() {
		return tribunalRepository.findAll();
	}

	@Override
	public Tribunal findOne(Long id) {
		return tribunalRepository.findById(id).get();
	}

	@Override
	public Tribunal save(Tribunal tribunal) {
		return tribunalRepository.save(tribunal);
	}

	@Override
	public void delete(Long id) {
		tribunalRepository.deleteById(id);
	}

}
