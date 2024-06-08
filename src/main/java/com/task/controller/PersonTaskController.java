package com.task.controller;

import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.dto.PersonDto;
import com.task.service.PersonService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000/")
public class PersonTaskController {
	   
     
	@Autowired
	private PersonService pService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody PersonDto pDto){
		
		
		   
		String  result = pService.register(pDto);
		
		
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	  
	  

}



 
