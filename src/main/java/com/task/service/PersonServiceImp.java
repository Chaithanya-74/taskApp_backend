package com.task.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dto.LoginDtoRequest;
import com.task.dto.PersonDto;
import com.task.model.LoginStatus;
import com.task.model.Person;
import com.task.model.TaskLoginSession;
import com.task.repository.LoginSessionRepo;
import com.task.repository.PersonRepo;

import jakarta.websocket.Session;


@Service
public class PersonServiceImp implements PersonService {
	
	@Autowired
	private PersonRepo pRepo;
	
	
	@Autowired
	private LoginSessionRepo lRepo;

	@Override
	public String register(PersonDto pDto) {
		// TODO Auto-generated method stub
		
		Person p = new Person();
		
		p.setName(pDto.getName());
		p.setEmail(pDto.getEmail());
		p.setPassword(pDto.getPassword());;
		
		Person p1 = pRepo.save(p);
		
		
		if(p1 != null) {
			 return "Register seccussfully";
		}else {
			throw new RuntimeException("error occured while registering");
		}
	}

	@Override
	public String login(LoginDtoRequest Dto) {
		// TODO Auto-generated method stub
		               
		Person person = pRepo.findByEmail(Dto.getEmail())
				.orElseThrow(() -> new RuntimeException("Email Is not registerd"+Dto.getEmail()));
		
		if(person.getPassword().equals(Dto.getPassword()) ) {
			TaskLoginSession session=new TaskLoginSession();
			
			session.setUser(person);
			session.setSessiontokeSn(UUID.randomUUID());
			session.setStatus(LoginStatus.LOGOUT);
			session.setLaststartDate(LocalDateTime.now());
			TaskLoginSession session1 = lRepo.save(session);
			if(session1 !=null) {
				return session1.getSessiontokeSn().toString();
				
			}else {
				throw new RuntimeException("Error is occured while login process");
				
			}
			
		}else {
			throw new RuntimeException("Wrong Credentails!");
			
		}
	}

	@Override
	public Person checkLogin(String token) {
		// TODO Auto-generated method stub
		
		TaskLoginSession session1 = lRepo.findBySessiontokeSn(UUID.fromString(token)).orElseThrow(() -> new RuntimeException("Login again, Token isnot correct"));
		
		
		
		if(LocalDateTime.now().minusMinutes(30).isBefore(session1.getLaststartDate())){
			session1.setLaststartDate(LocalDateTime.now());
			lRepo.save(session1);
		
		return session1.getUser();
		
	    }else {
//			LoginSessionRepo.delete(session);
			throw new RuntimeException("Session is expired login again");
			
		}
	
	

		
		
	}


}

