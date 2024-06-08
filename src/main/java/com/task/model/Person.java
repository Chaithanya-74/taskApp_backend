package com.task.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personId;
	
	private String name;
	
	
	@Column(unique= true)
	private String email;
	
	
	private String password;
}
