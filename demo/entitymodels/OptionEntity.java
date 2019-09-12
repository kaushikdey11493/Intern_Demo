package com.example.demo.entitymodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="option_table")
public class OptionEntity
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="optid",length=11)
	private int id;
	
	@Column(name="options",length=600)
	private String option;
	
	@ManyToOne
	@JoinColumn(name="idq")
	private QuestionEntity questionEntity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public QuestionEntity getQuestionEntity() {
		return questionEntity;
	}

	public void setQuestionEntity(QuestionEntity questionEntity) {
		this.questionEntity = questionEntity;
	}
	
	
}
