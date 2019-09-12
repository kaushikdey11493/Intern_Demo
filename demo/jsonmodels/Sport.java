package com.example.demo.jsonmodels;

import java.util.List;

public class Sport
{
	private int record;
	private List<Question> q;

	public List<Question> getQ() {
		return q;
	}

	public void setQ(List<Question> q) {
		this.q = q;
		record=q.size();
	}

	@Override
	public String toString() {
		return "Sport [q=" + q + "]";
	}

	public int getRecord() {
		return record;
	}

	public void setRecord(int record) {
		this.record = record;
	}
	
	
}
