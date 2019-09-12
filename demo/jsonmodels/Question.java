package com.example.demo.jsonmodels;

import java.util.List;

public class Question
{
	private String question;
	private List<String> options;
	private String answer;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Question [question=" + question + ", options=" + options + ", answer=" + answer + "]";
	}
	

}
