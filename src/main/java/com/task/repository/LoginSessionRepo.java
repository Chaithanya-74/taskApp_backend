package com.task.repository;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.model.TaskLoginSession;
import com.task.model.TaskModel;



@Repository



public interface LoginSessionRepo  extends JpaRepository<TaskLoginSession,Integer>{

	
	


		
		
		public Optional<TaskLoginSession> findBySessiontokeSn(UUID token);

		
	}

	
	

