package com.project.QuizApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.QuizApp.model.*;
import com.project.QuizApp.service.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class QuizController {
	@Autowired
	UserSubmissionService userSubmissionService;
	@Autowired
	QuizService quizService;
	@Autowired
	QuestionService questionService;
	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("welcome", "home");
		return "welcome";
	}
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("welcome", "admin");
		return "welcome";
	}
	@GetMapping("/viewAllQuiz")
	public String index(@RequestParam("userName") String userName, Model model,HttpSession session) {
		List<QuizWrapper> quizWrappers=quizService.findAllQuiz();
		session.setAttribute("userName", userName);
		model.addAttribute("QuizList", quizWrappers);
		return "index";
	}	
	
	 @PostMapping("/get") 
	 public String showQuiz(@RequestParam("quizId") Integer id,Model model) {
		 List<QuestionWrapper>questionWrapper=quizService.findQuiz(id);
		 model.addAttribute("questions", questionWrapper);
		 model.addAttribute("quizId", id);
		 return "QuizPage";
	}
	 @PostMapping("/result/{id}")
	 public String QuizCalculation(@PathVariable Integer id,@RequestParam Map<String, String> map,Model model,HttpSession session) {
		 List<Response> responses = new ArrayList<>();
		    for (Map.Entry<String, String> entry : map.entrySet()) {
		        Response response = new Response();
		        response.setQid(Integer.parseInt(entry.getKey()));
		        response.setResult(entry.getValue());
		        responses.add(response);
		    }
		    int mark = quizService.markCalculation(id, responses);
		    model.addAttribute("mark", mark);
		    model.addAttribute("userName", session.getAttribute("userName"));
		    UserSubmission userSubmission = quizService.createUserSubmission((String) session.getAttribute("userName"),mark,responses);
		    session.setAttribute("TotalNumberOfAttemptedQuestions", responses.size());
		    quizService.submissionSaving(userSubmission);
		    return "result";
	}
	 @PostMapping("/adminLogin")
	 public String AdminLogin(@RequestParam("adminUserName") String adminUserName,@RequestParam("adminPassword") String adminPassword,Model model) {
		if (quizService.adminLogin(adminUserName,adminPassword)!=0) {
			return "admin";
		}
		return admin(model);
	}
	 @GetMapping("/adminPanel")
	 public String viewAllQuestion(@RequestParam("adminSection") String adminSection,Model model) {
		 if (adminSection.equals("viewQuestions")) {
			List<Question>questions= questionService.viewAllQuestion();
			model.addAttribute("questions", questions);
		}else if (adminSection.equals("addNewQuestion")) {
		
		}else if (adminSection.equals("viewSubmissions")) {
			List<UserSubmission>userSubmissions=userSubmissionService.viewSubmissions();
			for (UserSubmission userSubmission : userSubmissions) {
				System.out.println(userSubmission);
			}
			Map<UserSubmission,List<Question>> submissionMap=userSubmissionService.mappingOfUserSubmissionList(userSubmissions);
			model.addAttribute("mappedSubmission",submissionMap);
		}else if (adminSection.equals("addQuiz")) {
			
		}
		 model.addAttribute("adminSection", adminSection);
		 
		return "admin";
	}
	 
	 @PostMapping("/deleteQuestion")
	 public String deleteQuestion(@RequestParam("questionId") Integer questionId , Model model) {
		 questionService.deleteQuestion(questionId);
		return viewAllQuestion("viewQuestions",model);
	}
	 @PostMapping("/addQuestion")
	 public String addQuestion(@ModelAttribute Question question, Model model) {
		 System.out.println("add question received");
		 System.out.println(question.getCategory());
		 System.out.println(question.getqId());
		questionService.addQuestion(question);
		return viewAllQuestion("viewQuestions", model);
	}
	 @PostMapping("/createQuiz")
	 public String addQuiz(@RequestParam("quizTitle") String title,@RequestParam("quizNumber")Integer numQ, @RequestParam("quizCategory") String category) {
		 quizService.createQuiz(category, title, numQ);
		return "admin";
	}
	 @GetMapping("/testException")
	 public String testException() {
	     throw new RuntimeException("Testing Global Exception Handling");
	 }
	 @GetMapping("/updateQuestion")
	 public String updateQuestion(@RequestParam("id") Integer id,Model model) {
		 model.addAttribute("questionDetail", questionService.viewSingleQuestion(id));
		 model.addAttribute("adminSection", "viewSingleQuestion");
		return "admin";
	}

}
