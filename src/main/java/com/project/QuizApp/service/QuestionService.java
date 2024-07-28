package com.project.QuizApp.service;

<<<<<<< HEAD

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
=======
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

>>>>>>> 027fcfc66e551ae4950edf11908efa89e17dc2d8
import com.project.QuizApp.Repo.QuestionRepo;
import com.project.QuizApp.Repo.QuizRepo;
import com.project.QuizApp.model.Question;
import com.project.QuizApp.model.Quiz;

@Service
public class QuestionService {
	@Autowired
	QuestionRepo questionRepo;
	@Autowired
	QuizRepo quizRepo;

	public List<Question> viewAllQuestion() {
		return questionRepo.findAll();
	}

	public void deleteQuestion(Integer questionId) {
		Question question = questionRepo.findById(questionId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid question Id:" + questionId));
		System.out.println(question);
		List<Quiz> list = quizRepo.findAll();
		for (Quiz quiz : list) {
			if (quiz.getQuestion().contains(question)) {
				quiz.getQuestion().remove(question);
				System.out.println("deleted");
			}
		}
		quizRepo.saveAll(list);
		questionRepo.deleteById(questionId);

	}

	public void addQuestion(Question question) {
<<<<<<< HEAD
		question.setCategory(question.getCategory().toLowerCase());
		System.out.println(question.getqId());
=======
>>>>>>> 027fcfc66e551ae4950edf11908efa89e17dc2d8
		questionRepo.save(question);

	}

<<<<<<< HEAD
	public Question viewSingleQuestion(Integer id){
		Question question = questionRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid question Id:" + id));
		return question;
	}

=======
>>>>>>> 027fcfc66e551ae4950edf11908efa89e17dc2d8
}
