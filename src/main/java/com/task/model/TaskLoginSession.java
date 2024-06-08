package com.task.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
public class TaskLoginSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sessionId;
	
	private UUID sessiontokeSn;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="personId")
	private Person user;
	
	private LocalDateTime laststartDate;
	
	private LoginStatus status;
	
	
	

}
