package com.dipak.cs.api.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * @author Dipak
 * @version 1
 * @apiNote custom error response for global as well as specific errors
 */

@Data
@AllArgsConstructor
public class ErrorDetails {
	  private Date timestamp;
	  private String message;
	  private String details;

}