package com.dipak.cs.api.model;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Dipak
 * @version 1
 * @apiNote Model class whose fields are used for the input for operation.
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestedOperation {
	
	@NotBlank(message = "num1 cant be blank")
	@Pattern(regexp="[0-9]*",message ="invalid number num1") //check if input is a number
	private String num1;
	
	@Pattern(regexp="[0-9]*",message ="invalid number num2") //check if input is a number
	@NotBlank(message = "num2 cant be blank")
	private String num2;
	
	@NotBlank(message = "operator cant be blank")
	@Pattern(regexp="ADD|SUBTRACT|DIVIDE|MULTIPLY|MODULO",message ="invalid operator") //check if operator is in list the of valid operators
	private String operator;
}
