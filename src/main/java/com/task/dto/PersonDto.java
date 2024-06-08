package com.task.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
      
	  private String name;
	  
	  private String email;
	  
	  private String password;

	@Override
	public String toString() {
		return "PersonDto [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	  
	  
	  
}
