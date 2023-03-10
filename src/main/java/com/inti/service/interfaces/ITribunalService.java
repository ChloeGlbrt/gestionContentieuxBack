package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Tribunal;

public interface ITribunalService {

	List<Tribunal> findAll();

	Tribunal findOne(Long id);

	Tribunal save(Tribunal tribunal);

	void delete(Long id);

}
