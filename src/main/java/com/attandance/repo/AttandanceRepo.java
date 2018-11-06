package com.attandance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attandance.domain.Attndance;

@Repository
public interface AttandanceRepo extends JpaRepository<Attndance, Long>{

}
