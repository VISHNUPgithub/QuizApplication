package com.project.QuizApp.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserSubmission implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String questionId;
	private String userName;
	private String submission;
	private int mark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSubmission() {
		return submission;
	}
	public void setSubmission(String submission) {
		this.submission = submission;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public UserSubmission(int id, String questionId, String userName, String submission, int mark) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.userName = userName;
		this.submission = submission;
		this.mark=mark;
	}
	public UserSubmission() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserSubmission [id=" + id + ", questionId=" + questionId + ", userName=" + userName + ", submission="
				+ submission + ", mark=" + mark + "]";
	}
	
}
