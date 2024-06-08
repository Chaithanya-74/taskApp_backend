package com.task.service;

import com.task.dto.LoginDtoRequest;
import com.task.dto.LoginDtoResponse;
import com.task.dto.PersonDto;
import com.task.model.Person;

public interface PersonService {
      
	 public String register(PersonDto pDto);
	 public String login(LoginDtoRequest Dto);
	 public Person checkLogin(String token);
}
