package com.example.demo.jsonmodels;

public class QuizWrapper {
	
	private int total_record;
	
	private Quiz quiz;
	
	public int getTotal_record() {
		return total_record;
	}

	public void setTotal_record(int total_record) {
		this.total_record = total_record;
	}

	public QuizWrapper() {
		super();
		quiz=new Quiz();
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Override
	public String toString() {
		return "QuizWrapper [quiz=" + quiz + "]\n";
	}
}
