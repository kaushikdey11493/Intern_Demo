package com.example.demo.controllers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data_access_object.QuestionRepo;
import com.example.demo.entitymodels.OptionEntity;
import com.example.demo.entitymodels.QuestionEntity;
import com.example.demo.jsonmodels.Math;
import com.example.demo.jsonmodels.Question;
import com.example.demo.jsonmodels.Quiz;
import com.example.demo.jsonmodels.QuizWrapper;
import com.example.demo.jsonmodels.Sport;

@RestController
public class DemoController 
{
	@Autowired
	QuestionRepo questionRepo;
	
	@PostMapping(consumes= {MediaType.APPLICATION_XML_VALUE,
							MediaType.APPLICATION_JSON_VALUE},
				produces = {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_VALUE},
				path = "/quiz"
			)
	public ResponseEntity<HashMap<String, String>> quiz(@RequestBody QuizWrapper quizWrapper) {
		HashMap<String, String> map=new HashMap<>();
		int t=0;
		QuestionEntity qe;
		OptionEntity opte;
		
		Quiz quiz=quizWrapper.getQuiz();
		Math math=quiz.getMaths();
		
		try {
			for(Question q : math.getQ()) {
				qe=new QuestionEntity();
				qe.setType("math");
				qe.setQuestion(q.getQuestion());
				qe.setAnswer(q.getAnswer());
				for(String s : q.getOptions()) {
					opte=new OptionEntity();
					opte.setOption(s);
					opte.setQuestionEntity(qe);
					qe.getOptions().add(opte);
				}
				questionRepo.save(qe);
				t++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		map.put("math_record_inserted", ""+t);
		
		Sport sport=quiz.getSports();
		t=0;
		try {
			for(Question q : sport.getQ()) {
				qe=new QuestionEntity();
				qe.setType("sport");
				qe.setQuestion(q.getQuestion());
				qe.setAnswer(q.getAnswer());
				for(String s : q.getOptions()) {
					opte=new OptionEntity();
					opte.setOption(s);
					opte.setQuestionEntity(qe);
					qe.getOptions().add(opte);
				}
				questionRepo.save(qe);
				t++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		map.put("sport_record_inserted", ""+t);
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_VALUE},
				path="/quiz")
	public ResponseEntity<QuizWrapper> getQuiz()
	{
		int t=0;
		QuizWrapper quizWrapper=new QuizWrapper();
		
		List<QuestionEntity> list=questionRepo.findByType("sport");
		List<Question> questionList=new LinkedList<>();
		for(QuestionEntity qe : list) {
			Question q=new Question();
			q.setQuestion(qe.getQuestion());
			q.setAnswer(qe.getAnswer());
			q.setOptions(qe.getOptionList());
			questionList.add(q);
		}
		
		quizWrapper.getQuiz().getSports().setQ(questionList);
		t=questionList.size();
		questionList=new LinkedList<>();
		
		list=questionRepo.findByType("math");
		for(QuestionEntity qe : list) {
			Question q=new Question();
			q.setQuestion(qe.getQuestion());
			q.setAnswer(qe.getAnswer());
			q.setOptions(qe.getOptionList());
			questionList.add(q);
		}
		t=t+questionList.size();
		quizWrapper.getQuiz().getMaths().setQ(questionList);
		quizWrapper.setTotal_record(t);
		
		return new ResponseEntity<>(quizWrapper, HttpStatus.OK);
	}

}
