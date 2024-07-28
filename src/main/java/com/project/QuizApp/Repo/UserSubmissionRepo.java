package com.project.QuizApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.QuizApp.model.UserSubmission;

public interface UserSubmissionRepo extends JpaRepository<UserSubmission, Integer>{
	
}
