package com.task.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskModel {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer taskId;
	  
	  private String taskName;
	  
	  private String description;
	  
	  private LocalDate startDate;
	  
	  
	  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	  @JoinColumn(name="personId")
	  private Person person;	
	  
	  private LocalDate endDate;	

	
	
	
	
	
	
	
	
	
	
	  
}
