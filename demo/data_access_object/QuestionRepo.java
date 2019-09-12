package com.example.demo.data_access_object;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitymodels.QuestionEntity;

public interface QuestionRepo extends JpaRepository<QuestionEntity, Integer>{
	
	public List<QuestionEntity> findByType(String type);

}
