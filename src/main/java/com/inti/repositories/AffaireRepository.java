package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Affaire;

@Repository
public interface AffaireRepository extends JpaRepository<Affaire, Long>{
	List<Affaire> findByReference(String reference);

}
