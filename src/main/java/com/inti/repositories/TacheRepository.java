package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Tache;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {


}


