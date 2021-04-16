package com.dipak.cs.api.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dipak.cs.api.model.ErrorDetails;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
@RestController
public class exceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DividedByZeroException.class)
	public final ResponseEntity<ErrorDetails> handleDividedByZeroException(DividedByZeroException ex,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	

		/**
		 * customized default error message for spring @Valid validation
		 * 
		 * This method will handle {@link MethodArgumentNotValidException}
		 * exception, whenever there is a invalid argument in the input provided then from this
		 * method it will get handled.
		 * 
		 * @param MethodArgumentNotValidException object,web request
		 * @return {@link ErrorDetails} object Exception format in the form of
		 *         Custom Error Response object
		 * 
		 * @see ErrorDetails
		 */
	@Override
	public ResponseEntity<Object>  handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getBindingResult().getFieldErrors().stream()
				.map(err -> err.getDefaultMessage()+"-> "+err.getRejectedValue()).collect(java.util.stream.Collectors.joining(", ")),
				request.getDescription(false));
		return new ResponseEntity<>(
				errorDetails,
				HttpStatus.BAD_REQUEST);
	}

}