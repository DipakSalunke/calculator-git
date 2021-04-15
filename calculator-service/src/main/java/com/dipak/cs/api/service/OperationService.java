package com.dipak.cs.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dipak.cs.api.entity.OpResult;
import com.dipak.cs.api.entity.Operation;
import com.dipak.cs.api.exception.DividedByZeroException;
import com.dipak.cs.api.repository.OpResultRepository;
import com.dipak.cs.api.repository.OperationRepository;

@Service
public class OperationService {
	@Autowired
	private OperationRepository repository;
	@Autowired
	private OpResultRepository resrepository;

	private OpResult result = new OpResult();

	public OpResult saveOperation(Operation operation) {
		String s = operation.getNum1() + " and " + operation.getNum2() + " is ";
		switch (operation.getOperator()) {
		case "ADD":

			s = "Sum of " + s + (operation.getNum1() + operation.getNum2());
			break;
		case "SUBSTRACT":
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

	public Map<Integer, String> getOperations() {
		List <Operation> operations= repository.findAll();
		Map <Integer,String> OpToString= new HashMap<>();
		
		for(int i=0;i<operations.size();i++) {
			OpToString.put(operations.get(i).getId(),operations.get(i).getOperator() +
					" numbers,number1=" + operations.get(i).getNum1() + " and number2=" + operations.get(i).getNum2());
		}
		
		return OpToString;
	}

	public Optional<OpResult> getResult(int id) {
		return resrepository.findById(id);
	}

	public Optional<Operation> getOperation(int id) {
		return repository.findById(id);
	}

}
