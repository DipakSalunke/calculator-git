package com.dipak.cs.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "OPERATION_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation {
	@Id
	@GeneratedValue
	private int id;
	private double num1;
	private double num2;
	@NotBlank
	private String operator;

	@Override
	public String toString() {
		return   id + "::" + operator + " numbers,number1=" + num1 + " and number2=" + num2;
	}

}
