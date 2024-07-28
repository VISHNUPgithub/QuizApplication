package com.project.QuizApp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Quiz {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int qId;
	private String qTitle;
    private String category;
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	private List<Question> question;
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Question> getQuestion() {
		return question;
	}
	public void setQuestion(List<Question> question) {
		this.question = question;
	}
	public Quiz(int qId, String qTitle, String category, List<Question> question) {
		super();
		this.qId = qId;
		this.qTitle = qTitle;
		this.category = category;
		this.question = question;
	}
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
