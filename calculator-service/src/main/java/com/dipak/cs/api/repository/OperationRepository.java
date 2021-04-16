package com.dipak.cs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dipak.cs.api.entity.Operation;

/**
 * @author dipak
 * This repository is used to manage operation table's crude operations
 *	JpaRepository is JPA specific extension of Repository. 
 *	it contains API for basic CRUD operations.
 */
public interface OperationRepository extends JpaRepository<Operation,Integer>{

}
