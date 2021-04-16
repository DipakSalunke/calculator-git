package com.dipak.cs.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.dipak.cs.api.entity.OpResult;
import com.dipak.cs.api.entity.Operation;
import com.dipak.cs.api.model.Replay;
import com.dipak.cs.api.model.RequestedOperation;
import com.dipak.cs.api.service.OperationService;

//@RunWith(SpringRunner.class)
@RunWith(SpringRunner.class)
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
	private OpResult result;
	@Mock
	private Operation operation;
	@Mock
	private OperationService service;
	@Before
	public void setup()
	{
		roperation = mock(RequestedOperation.class);
		roperation.setNum1("44");
		roperation.setNum2("33");
		roperation.setOperator("ADD");
		
		operation = new Operation();
		operation.setNum1(3.1);
		operation.setNum2(3.0);
		operation.setOperator("ADD");
		
		replay = new Replay();
		replay.setReplaySeq(1);
	}
	
	@Test
	public void testOperation() throws Exception{
		ResponseEntity<OpResult> rentity = operationController.performOperation(roperation);
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
