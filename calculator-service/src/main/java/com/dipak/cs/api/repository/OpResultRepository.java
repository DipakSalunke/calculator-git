package com.dipak.cs.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.dipak.cs.api.entity.OpResult;
/**
 * @author dipak
 * This repository is used to manage result table's crude operations
 *	JpaRepository is JPA specific extension of Repository. 
 *	it contains API for basic CRUD operations.
 */
public interface OpResultRepository extends JpaRepository<OpResult,Integer>{

}
