package com.project.QuizApp.controller;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
=======
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
>>>>>>> 027fcfc66e551ae4950edf11908efa89e17dc2d8
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.QuizApp.model.*;
import com.project.QuizApp.service.*;
<<<<<<< HEAD
=======

>>>>>>> 027fcfc66e551ae4950edf11908efa89e17dc2d8
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
<<<<<<< HEAD
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
=======
		 List<Response> response = new ArrayList<>();
		// List<UserSubmission> submission = new ArrayList<>();
		 for ( Map.Entry<String, String> m  : map.entrySet()) {
			Response res = new Response();
			res.setQid(Integer.parseInt(m.getKey()));
			res.setResult(m.getValue());
			response.add(res);
		}
		 int count= response.size();
		 int mark=quizService.markCalculation(id,response);
		 model.addAttribute("mark",mark);
		 model.addAttribute("userName", session.getAttribute("userName"));
		 UserSubmission Usub = new UserSubmission();
		 StringBuilder questionId = new StringBuilder();
		 StringBuilder submission = new StringBuilder();
		 int index=0;
		 for (Response r : response) {
			 index++;
			 questionId.append(r.getQid());
			 submission.append(r.getResult());
			 if (index<count) {
				 questionId.append(",");
				 submission.append(",");
			}
		 }
		 session.setAttribute("TotalNumberOfAttemptedQuestions", count);
		 Usub.setUserName((String)session.getAttribute("userName"));
		 Usub.setMark(mark);
		 Usub.setQuestionId(questionId.toString());
		 Usub.setSubmission(submission.toString());
		 quizService.submissionSaving(Usub);
		return "result";
>>>>>>> 027fcfc66e551ae4950edf11908efa89e17dc2d8
	}
	 @PostMapping("/adminLogin")
	 public String AdminLogin(@RequestParam("adminUserName") String adminUserName,@RequestParam("adminPassword") String adminPassword,Model model) {
		if (quizService.adminLogin(adminUserName,adminPassword)!=0) {
			return "admin";
<<<<<<< HEAD
		}
=======
		} 
>>>>>>> 027fcfc66e551ae4950edf11908efa89e17dc2d8
		return admin(model);
	}
	 @GetMapping("/adminPanel")
	 public String viewAllQuestion(@RequestParam("adminSection") String adminSection,Model model) {
		 if (adminSection.equals("viewQuestions")) {
			List<Question>questions= questionService.viewAllQuestion();
			model.addAttribute("questions", questions);
		}else if (adminSection.equals("addNewQuestion")) {
		
		}else if (adminSection.equals("viewSubmissions")) {
<<<<<<< HEAD
			List<UserSubmission>userSubmissions=userSubmissionService.viewSubmissions();
			for (UserSubmission userSubmission : userSubmissions) {
				System.out.println(userSubmission);
			}
			Map<UserSubmission,List<Question>> submissionMap=userSubmissionService.mappingOfUserSubmissionList(userSubmissions);
			model.addAttribute("mappedSubmission",submissionMap);
		}else if (adminSection.equals("addQuiz")) {
			
=======
			System.out.println("test 1");
			List<UserSubmission>userSubmissions=userSubmissionService.viewSubmissions();
			Map<UserSubmission,List<Question>> submissionMap=userSubmissionService.mappingOfUserSubmissionList(userSubmissions);
			List<String[]> list = new ArrayList<>();
			for (UserSubmission userSubmission : userSubmissions) {
				String[] string=userSubmission.getSubmission().split(",");
				list.add(string);
			}
			
			for (String[] strings : list) {
				for (String s : strings) {
					System.out.println(s);
				}
			}
			model.addAttribute("list", list);
			model.addAttribute("mappedSubmission",submissionMap);
			model.addAttribute("submissions", userSubmissions);
>>>>>>> 027fcfc66e551ae4950edf11908efa89e17dc2d8
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
<<<<<<< HEAD
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

=======
		questionService.addQuestion(question);
		return viewAllQuestion("viewQuestions", model);
	}
>>>>>>> 027fcfc66e551ae4950edf11908efa89e17dc2d8
}
