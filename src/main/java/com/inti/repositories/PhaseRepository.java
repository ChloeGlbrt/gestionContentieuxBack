package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Phase;

@Repository
public interface PhaseRepository extends JpaRepository<Phase, Long>{

}
