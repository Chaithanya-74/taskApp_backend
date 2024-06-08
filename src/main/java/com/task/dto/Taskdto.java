package com.task.dto;




import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Taskdto {  
	
	  public String taskName;
	 
	  public String token;
	  
	  public String description;
	  
	  public LocalDate startDate;
	  
	  public LocalDate endDate;
	  
	 
	  
	
}





