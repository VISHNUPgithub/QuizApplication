package com.project.QuizApp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.QuizApp.model.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer>{
	@Query(value = "select * from question q where q.category=:category order by rand() limit :numQ",nativeQuery = true)
	List<Question> getQuestions(String category, Integer numQ);
     
}
