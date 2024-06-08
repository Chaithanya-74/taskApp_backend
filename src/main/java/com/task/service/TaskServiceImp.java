package com.task.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.task.dto.LoginDtoResponse;
import com.task.dto.Taskdto;
import com.task.model.Person;
import com.task.model.TaskLoginSession;
import com.task.model.TaskModel;
import com.task.repository.LoginSessionRepo;
import com.task.repository.PersonRepo;
import com.task.repository.TaskRepository;


@Service
public class TaskServiceImp   implements TaskService {
	
	
	@Autowired
	private TaskRepository taskRepo;
	
	
	@Autowired
	private PersonRepo personRepo;
	
	
	@Autowired
	private LoginSessionRepo loginsessionRepo;

	
	@Autowired
	private PersonService pService;
	
	
	@Override
	public List<TaskModel> getAllTask() {
		// TODO Auto-generated method stub
		
		
		
	    List<TaskModel> tasks =	taskRepo.findAll();
		
	    System.out.println(taskRepo.findById(1));
		
		return tasks;
	}

	

	@Override
	public TaskModel getTaskById(Integer id) {
		// TODO Auto-generated method stub
		
	     Optional<TaskModel> task =	taskRepo.findById(id);
	     
	     
	     if(task.isPresent()) {
	    	 return task.get();
	     }else {
	    	 throw new RuntimeException("There is not task with this id " +id);
	     }
		
		
	}

	
	@Override
	public List<TaskModel> getTaskByName(String name) {
		// TODO Auto-generated method stub
		   System.out.println(name);
		return taskRepo.findByTaskName("%"+name+"%");
		
		
	}

	
	
	
	@Override
	public TaskModel deleteTask(Integer taskId) {
		// TODO Auto-generated method stub
		Optional<TaskModel> task =taskRepo.findById(taskId);
		if (task.get()!=null) {	
			
			   taskRepo.delete(task.get());
		 
			   return task.get();
		
		}else {
		throw new RuntimeException("task is not found with id: "+taskId);
	     }
	}

	@Override
	public String register(Taskdto tDto) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public String login(LoginDtoResponse Dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task checkLogin(String token) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public TaskModel addTask(Taskdto tDto){
		
		 
		 
		 
		Person p1 =  pService.checkLogin(tDto.getToken());
		
		 
		 if(p1 != null) {
			
			  
			// save the task with particular person
			   TaskModel taskM = new TaskModel();
			   
			      taskM.setDescription(tDto.getDescription());
			      taskM.setTaskName(tDto.getTaskName());
			      taskM.setPerson(p1);
			      taskM.setStartDate(tDto.getStartDate());
			      taskM.setEndDate(tDto.getEndDate());
			  
			      
			      //save this task model in database 
			    TaskModel task1 =    taskRepo.save(taskM);
			       
			      return task1;
		 }else {
			 throw new RuntimeException("Token is expired login agian" + tDto.getToken());
		 }
		 


	}
	
	
}
		



	


