package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Phase;

public interface IPhaseService {

	List<Phase> findAll();

	Phase findOne(Long id);

	Phase save(Phase phase);

	void delete(Long id);

}
