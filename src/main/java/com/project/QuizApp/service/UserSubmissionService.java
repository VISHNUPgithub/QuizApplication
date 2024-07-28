package com.project.QuizApp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.QuizApp.Repo.QuestionRepo;
import com.project.QuizApp.Repo.UserSubmissionRepo;
import com.project.QuizApp.model.Question;
import com.project.QuizApp.model.UserSubmission;
@Service
public class UserSubmissionService {
	@Autowired
	UserSubmissionRepo userSubmissionRepo;
	@Autowired
	QuestionRepo questionRepo;
	public List<UserSubmission> viewSubmissions() {
		List<UserSubmission>userSubmissions=userSubmissionRepo.findAll();
		return userSubmissions;
	}
	public Map<UserSubmission, List<Question>> mappingOfUserSubmissionList(List<UserSubmission> userSubmissions) {
		HashMap<UserSubmission, List<Question>> listMap = new HashMap<>();
		for (UserSubmission userSubmission : userSubmissions) {
			String[] questionId=userSubmission.getQuestionId().split(",");
			List<Question> listQus = new ArrayList<>();
			for (String qId : questionId) {
				listQus.add(questionRepo.findById(Integer.parseInt(qId)).orElseThrow());
			}
			listMap.put(userSubmission, listQus);
		}
		return listMap;
	}


}
