package com.example.demo.jsonmodels;

public class Quiz 
{
	private Sport sports;
	private Math maths;
	
	public Quiz() {
		super();
		sports=new Sport();
		maths=new Math();
	}
	
	public Sport getSports() {
		return sports;
	}
	public void setSports(Sport sports) {
		this.sports = sports;
	}
	public Math getMaths() {
		return maths;
	}
	public void setMaths(Math maths) {
		this.maths = maths;
	}
	@Override
	public String toString() {
		return "Quiz [sports=" + sports + ", maths=" + maths + "]";
	}
		
}
