package com.task.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Taskk {       
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer taskId;
	 
	 private String taskName;
	  
	  
	  private String employeeName;
	  
	  private String contact;
	  
	  private String password;
	  
}






