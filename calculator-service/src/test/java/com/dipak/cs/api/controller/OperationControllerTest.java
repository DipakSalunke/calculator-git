package com.dipak.cs.api.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.dipak.cs.api.entity.Operation;
import com.dipak.cs.api.model.Replay;
import com.dipak.cs.api.model.RequestedOperation;
import com.dipak.cs.api.service.OperationService;

@AutoConfigureMockMvc
@SpringBootTest
class OperationControllerTest {
	@InjectMocks
	private OperationController operationController;
	@Mock
	private RequestedOperation roperation;
	@Mock
	private Replay replay;
	@Mock
	private Operation operation;
	@Mock
	private OperationService service;
	@Before
	public void setup()
	{
		roperation = new RequestedOperation();
		roperation.setNum1("3.1");
		roperation.setNum2("3.0");
		roperation.setOperator("ADD");
		
		operation = new Operation();
		operation.setNum1(3.1);
		operation.setNum2(3.0);
		operation.setOperator("ADD");
		
		replay = new Replay();
		replay.setReplaySeq(1);
	}
	
	@Test
	public void testOperation() {
		ResponseEntity<?> rentity = operationController.operation(roperation);
		HttpStatus statusCode = rentity.getStatusCode();
		assertNotNull(statusCode);
		assertEquals(HttpStatus.OK,statusCode);

}
	
	@Test
	public void testListOperations() {
		ResponseEntity<?> rentity = operationController.listOperations();
		HttpStatus statusCode = rentity.getStatusCode();
		assertNotNull(statusCode);
		assertEquals(HttpStatus.OK,statusCode);

}
	
	@Test
	public void testReplayOperation() {
		ResponseEntity<?> rentity = operationController.replayOperation(replay);
		HttpStatus statusCode = rentity.getStatusCode();
		assertNotNull(statusCode);
		assertEquals(HttpStatus.OK,statusCode);

}
	
	
}
