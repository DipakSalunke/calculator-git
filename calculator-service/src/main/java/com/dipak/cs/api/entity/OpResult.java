package com.dipak.cs.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Dipak
 * @version 1
 * @apiNote entity class whose fields are used for the response for result
 *         to store in db.
 */

@Entity
@Table(name = "RESULT_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpResult {
	@Id
	@JsonIgnore
	private int id;
	private String result;
}
