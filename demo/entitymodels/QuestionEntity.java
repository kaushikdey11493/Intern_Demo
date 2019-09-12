package com.example.demo.entitymodels;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="question_table")
public class QuestionEntity 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idq",length=11)
	private Integer id;
	
	@Column(name="question",length=1000)
	private String question;
	
	@Column(name="answer",length=600)
	private String answer;
	
	@Column(name="type",length=20)
	private String type;
		
	@OneToMany(cascade=CascadeType.ALL,mappedBy="questionEntity")
	private List<OptionEntity> options=new LinkedList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<OptionEntity> getOptions() {
		return options;
	}

	public void setOptions(List<OptionEntity> options) {
		this.options = options;
	}
	
	public List<String> getOptionList() {
		List<String> list=new LinkedList<>();
		for(OptionEntity oe : options) {
			list.add(oe.getOption());
		}
		return list;
	}
	

}
