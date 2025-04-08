package com.banking.reportingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.reportingservice.dto.StatementDto;
import com.banking.reportingservice.entity.Statement;
import com.banking.reportingservice.service.ReportingService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import model.TransDto;

@RestController
@RequestMapping("/reports")
@CrossOrigin(origins = "*")
public class ReportingController {

	@Autowired
	private ReportingService reportingService;
	
	@PostMapping("/all")
	public ResponseEntity<List<TransDto>> getAllTransactions(@RequestBody StatementDto statement){
		List<TransDto> resp = reportingService.getTransactions(statement);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
}
