package com.dipak.cs.api.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dipak.cs.api.entity.OpResult;
import com.dipak.cs.api.entity.Operation;
import com.dipak.cs.api.model.Replay;
import com.dipak.cs.api.model.RequestedOperation;
import com.dipak.cs.api.service.OperationService;

@RestController
@RequestMapping("/api")
public class OperationController {
	@Autowired
	private OperationService service;

	@PostMapping("/operation")
	public ResponseEntity<OpResult> operation(@RequestBody @Valid RequestedOperation roperation){
		
		Operation operation = new Operation() ;
		
		operation.setNum1(Double.parseDouble(roperation.getNum1()));
		operation.setNum2(Double.parseDouble(roperation.getNum2()));
		operation.setOperator(roperation.getOperator());
		
		OpResult result = service.saveOperation(operation);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/operations")
	public ResponseEntity<?> listOperations() {
		
		return new ResponseEntity<>(service.getOperations(), HttpStatus.OK);
	}
	
	@GetMapping("/operation/replay")
	public ResponseEntity<?> replayOperation(@RequestBody @Valid Replay replay) {
		return new ResponseEntity<>(service.getResult(replay.getReplaySeq()), HttpStatus.OK);
	}
	
//	@GetMapping("/operation/replay2")
//	public ModelAndView replayOperation2(@RequestBody @Valid Replay replay) {
//		request.
//		return new ResponseEntity<>(service.getOperation(replay.getReplaySeq()), HttpStatus.OK);
//	}
}
