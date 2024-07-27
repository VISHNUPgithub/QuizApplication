package com.project.QuizApp.model;

public class Response {
	private int qid;
	private String result;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Response(int qid, String result) {
		super();
		this.qid = qid;
		this.result = result;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Response [qid=" + qid + ", result=" + result + "]";
	}
	
	
}
