package com.project.QuizApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.project.QuizApp.Repo.QuestionRepo;
import com.project.QuizApp.Repo.QuizRepo;
import com.project.QuizApp.model.Question;
import com.project.QuizApp.model.QuestionWrapper;
import com.project.QuizApp.model.Quiz;
import com.project.QuizApp.model.QuizWrapper;
import com.project.QuizApp.model.Response;
import com.project.QuizApp.model.UserSubmission;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class QuizService {
	
	@Autowired
	QuizRepo quizRepo;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	QuestionRepo questionRepo;
	
	public void createQuiz(String Category, String title, Integer numQ){
		String category=Category.toLowerCase();
		Quiz quiz=new Quiz();
		List<Question> question=questionRepo.getQuestions(category,numQ);
		quiz.setQuestion(question);
		quiz.setqTitle(title);
		quiz.setCategory(category);
		quizRepo.save(quiz);
	}
	public List<QuestionWrapper> findQuiz(Integer id) {
		List<QuestionWrapper> questionWrappers = new ArrayList<>();
		Optional<Quiz>quiz=quizRepo.findById(id);
		List<Question> qList=quiz.get().getQuestion();
		for (Question question : qList) {
			QuestionWrapper q = new QuestionWrapper(question.getqId(),question.getqTitle(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4());
			questionWrappers.add(q);
		}
		return questionWrappers;
	}
	public Integer markCalculation(Integer id, List<Response> responses) {
		Optional<Quiz> quiz = quizRepo.findById(id);
		List<Question> qList = quiz.get().getQuestion();
		int i=0,mark=0;
		for (Response r : responses) {
			if (r.getResult().equals(qList.get(i).getRightAnswer())) {
			  mark++;
			}
			i++;
		}
		return mark ;
	}
	public List<QuizWrapper> findAllQuiz() {
		List<Quiz> quiz =quizRepo.findAll();
		List<QuizWrapper> qWrapper=new ArrayList<>();
		for (Quiz q : quiz) {
			QuizWrapper qW = new QuizWrapper();
			qW.setqId(q.getqId());
			qW.setqTitle(q.getqTitle());
			qW.setCategory(q.getCategory());
			qWrapper.add(qW);
		}
		return qWrapper;
	}
	public void submissionSaving(UserSubmission usub) {
		String query="INSERT INTO user_submission (mark, question_id, submission, user_name) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(query, usub.getMark(),usub.getQuestionId(),usub.getSubmission(),usub.getUserName());
	}
	public Integer adminLogin(String adminUserName, String adminPassword) {
		String query = "SELECT EXISTS (SELECT * FROM quiz.admin_detail WHERE admin_password = ? AND admin_username= ?)";
		return jdbcTemplate.queryForObject(query, Integer.class, adminUserName, adminPassword);
	}
	 public UserSubmission createUserSubmission(String userName, int mark, List<Response> responses) {
	        UserSubmission userSubmission = new UserSubmission();
	        StringBuilder questionIds = new StringBuilder();
	        StringBuilder submission = new StringBuilder();
	        int count = responses.size();
	        int index = 0;

	        for (Response response : responses) {
	            index++;
	            questionIds.append(response.getQid());
	            submission.append(response.getResult());
	            if (index < count) {
	                questionIds.append(",");
	                submission.append(",");
	            }
	        }

	        userSubmission.setUserName(userName);
	        userSubmission.setMark(mark);
	        userSubmission.setQuestionId(questionIds.toString());
	        userSubmission.setSubmission(submission.toString());

	        return userSubmission;
	    }
}
