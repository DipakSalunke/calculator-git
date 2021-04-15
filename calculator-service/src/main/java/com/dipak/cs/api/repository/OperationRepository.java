package com.dipak.cs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dipak.cs.api.entity.Operation;

public interface OperationRepository extends JpaRepository<Operation,Integer>{

}
