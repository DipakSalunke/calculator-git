package com.dipak.cs.api.exception;

public class DividedByZeroException extends RuntimeException{
	/**
	 * custom exception for divide by zero error in calculator
	 */
	private static final long serialVersionUID = 1L;

	public DividedByZeroException(String exception) {
super(exception);
}
}