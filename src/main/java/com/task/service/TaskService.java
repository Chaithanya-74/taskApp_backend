package com.task.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.scheduling.config.Task;

import com.task.dto.LoginDtoResponse;
import com.task.dto.Taskdto;
import com.task.model.TaskModel;
import com.task.repository.LoginSessionRepo;



public interface TaskService {
      
	  public List<TaskModel> getAllTask();
	  
	  
	  public TaskModel addTask(Taskdto tDto);
	  
	  public TaskModel getTaskById(Integer id);
	  

	 


	   public List<TaskModel> getTaskByName(String name);




	public TaskModel deleteTask(Integer taskId);
	
	public String register(Taskdto tDto);
	public String login(LoginDtoResponse Dto);
	public Task checkLogin(String token);
	
}
	
	





