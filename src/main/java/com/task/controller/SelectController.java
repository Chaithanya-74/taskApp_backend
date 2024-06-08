package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.service.SelectService;

@RestController
@RequestMapping("/user")

public class SelectController {
	
	@Autowired
	private SelectService sService;
	
//	@GetMapping("/service/{id}")
//	public ResponseEntity<ervice> getSelectService (@PathVariable Integer id){
//		
//		Service service= selectService.getSelectService(id);
//		return new ResponseEntity<>(service, HttpStatus.OK);
//		
//	}

}
