package com.TrueMeds.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TrueMeds.model.InputDetails;

@Repository
public interface inputDetailsRepository extends JpaRepository<InputDetails, String>{

}
