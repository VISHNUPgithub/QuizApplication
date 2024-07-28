package com.project.QuizApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.QuizApp.model.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer>{
	
}
