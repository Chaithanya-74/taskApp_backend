package com.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.model.TaskModel;


@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Integer> {
    
	

	public List<TaskModel> findByTaskName(String string);
}
