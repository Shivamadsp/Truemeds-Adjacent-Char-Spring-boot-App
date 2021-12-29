package com.TrueMeds.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TrueMeds.model.OutputDetails;

@Repository
public interface OutputDetailsRepository extends JpaRepository<OutputDetails, String>{

}
