package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.dto.LoginDtoRequest;
import com.task.dto.LoginDtoResponse;
import com.task.dto.Taskdto;
import com.task.model.TaskModel;
import com.task.service.PersonService;
import com.task.service.TaskService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class TaskController {
	  
	
	 @Autowired
	 private TaskService taskService;
	 
	 @Autowired
	 private PersonService personService;
	 
	 
	 
	 @PostMapping("/task/add")
	 public ResponseEntity<TaskModel> addTask(@RequestBody Taskdto taskDto){
		 
		 
		TaskModel task = taskService.addTask(taskDto);
		 
		 return new ResponseEntity<TaskModel>(task, HttpStatus.CREATED);
		 
	 }
	 
	 
	 
	 
	 
	
	 @GetMapping("/tasks")
	 public ResponseEntity<List<TaskModel>> getAllTask(){
		 
		 
	     	List<TaskModel> tasks =   taskService.getAllTask();	
		 return new ResponseEntity<List<TaskModel>>(tasks, HttpStatus.OK);
	 }
	 
	 
	 @GetMapping("/task/get/{taskid}")
	 public ResponseEntity<TaskModel> getAllTask(@PathVariable("taskid") Integer id){
		 
		TaskModel task = taskService.getTaskById(id);
	     	
		 return new ResponseEntity<>(task, HttpStatus.OK);
	 }
	 
	 
	  
	  @GetMapping("/task/{taskname}")
	  public ResponseEntity<List<TaskModel>> getItemByName(@PathVariable("taskname") String name){
                  
		  List<TaskModel>  task = taskService.getTaskByName(name);
		  return new ResponseEntity<>(task, HttpStatus.OK);
	  }
	  
	  
	  
	  @PostMapping("/delete/{taskId}")
      public ResponseEntity<TaskModel> workTask(@PathVariable Integer taskId){
   	     
   	  TaskModel deleteTask =   taskService.deleteTask(taskId);
   	   
   	   return new ResponseEntity<>(deleteTask, HttpStatus.CREATED);
      }
	  
	  
	  @PostMapping("/login")
	  public ResponseEntity<LoginDtoResponse> login(@RequestBody LoginDtoRequest ldto){
		    
		   
		    String token =    personService.login(ldto);
		    
		    LoginDtoResponse  lresponse = new LoginDtoResponse(token);
		  
		  
      return new ResponseEntity<>(lresponse, HttpStatus.ACCEPTED);	  
	  
	  }
}



