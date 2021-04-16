package com.dipak.cs.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dipak.cs.api.entity.OpResult;
import com.dipak.cs.api.entity.Operation;
import com.dipak.cs.api.exception.DividedByZeroException;
import com.dipak.cs.api.model.RequestedOperation;
import com.dipak.cs.api.repository.OpResultRepository;
import com.dipak.cs.api.repository.OperationRepository;

@Service
public class OperationService {
	/**
	 * JPA Repository for operations table
	 * @see OperationRepository
	 */
	
	@Autowired
	private OperationRepository repository;
	/**
	 * JPA Repository for results table
	 * @see Operation
	 */
	
	@Autowired
	private OpResultRepository resrepository;
	
	
	/**
	 * validated {@link RequestedOperation} model mapped to {@link Operation} entity
	 * performs calculations and stores the operation and generated result string
	 * 
	 * {@link DividedByZeroException} will be thrown if invalid operation performed
	 * @see Operation
	 * @see OpResult
	 */
	
	public OpResult saveOperation(RequestedOperation roperation) {
		
		/**
		 * JPA entity for storing result string with operation id
		 * @see OpResult
		 */
		OpResult result = new OpResult();
		
		/**
		 * JPA entity for storing operation details
		 * @see Operation
		 */
		Operation operation = new Operation();
		operation.setNum1(Double.parseDouble(roperation.getNum1()));
		operation.setNum2(Double.parseDouble(roperation.getNum2()));
		operation.setOperator(roperation.getOperator());
		
		
		String s = operation.getNum1() + " and " + operation.getNum2() + " is ";
		switch (operation.getOperator()) {
		case "ADD":

			s = "Sum of " + s + (operation.getNum1() + operation.getNum2());
			break;
		case "SUBTRACT":
			s = "Substraction of " + s + (operation.getNum1() - operation.getNum2());
			break;
		case "DIVIDE":
			if (operation.getNum2() == 0)
				throw new DividedByZeroException("Can't perform Division By zero");
			s = "Division of " + s + (operation.getNum1() / operation.getNum2());
			break;
		case "MULTIPLY":
			s = "Multiplication of " + s + (operation.getNum1() * operation.getNum2());
			break;
		case "MODULO":
			if (operation.getNum2() == 0)
				throw new DividedByZeroException("Can't perform Modulo By zero");
			s = "Modulo of " + s + (operation.getNum1() % operation.getNum2());
			break;
		}
		repository.save(operation);
		result.setId(operation.getId());
		result.setResult(s);
		resrepository.save(result);
		return result;
	}

	/**
	 * list of operation objects mapped to id and string representation of the objects
	 * 
	 * @return operations performed in the current session
	 */
	
	public Map<Integer, String> getOperations() {
		List <Operation> operations= repository.findAll();
		Map <Integer,String> opToString= new HashMap<>();
		
		for(int i=0;i<operations.size();i++) {
			opToString.put(operations.get(i).getId(),operations.get(i).getOperator() +
					" numbers,number1=" + operations.get(i).getNum1() + " and number2=" + operations.get(i).getNum2());
		}
		
		return opToString;
	}
	
	/**
	 * provides result object mapped to requested operation replay
	 * 
	 * @return stored result 
	 */
	
	public Optional<OpResult> getResult(int id) {
		return resrepository.findById(id);
	}
	/**
	 * provides operation object mapped to requested operation replay
	 * 
	 * @return stored operation
	 */
	public Optional<Operation> getOperation(int id) {
		return repository.findById(id);
	}

}
