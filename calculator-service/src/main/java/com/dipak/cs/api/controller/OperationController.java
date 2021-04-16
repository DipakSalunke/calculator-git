package com.dipak.cs.api.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dipak.cs.api.entity.OpResult;
import com.dipak.cs.api.entity.Operation;
import com.dipak.cs.api.model.Replay;
import com.dipak.cs.api.model.RequestedOperation;
import com.dipak.cs.api.service.OperationService;

/**
 * @author Dipak
 * @version 1
 * @apiNote This class is handling all the end points for calculator service.
 *          This controller has three mappings for performing operation, getting
 *          list of operations performed and to replay any of the operation.
 * 
 * @see OperationService
 * @see RequestedOperation
 */
@RestController
@RequestMapping("/api")
public class OperationController {
	/**
	 * A service that contains the business logic for calculator
	 * 
	 * @see OperationService
	 */
	@Autowired
	private OperationService service;
	
	
	/**
	 * This method will return result of the operation.
	 * 
	 * Exceptions thrown during validation of input will be customized by
	 * {@link exceptionHandler} and returned
	 * 
	 * @param operation request body will be serialized to RequestedOperation model
	 *                  and validated
	 * @return result
	 */
	@PostMapping("/operation")
	public ResponseEntity<OpResult> performOperation(@RequestBody @Valid RequestedOperation roperation) {
		
		
		OpResult result = service.saveOperation(roperation);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * This method will return list of operations performed in the past during the
	 * session.
	 * 
	 * @return Map of id and operations
	 */
	@GetMapping("/operations")
	public ResponseEntity<Map<Integer, String>> listOperations() {

		Map<Integer, String> list = service.getOperations();

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	/**
	 * This method will replay the operation performed in the past.
	 * 
	 * @param Replay This model holds id of the requested operation
	 * @return result
	 */
	@PostMapping("/operation/replay")
	public ResponseEntity<Optional<OpResult>> replayOperation(@RequestBody @Valid Replay replay) {

		Optional<OpResult> result = service.getResult(replay.getReplaySeq());

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
