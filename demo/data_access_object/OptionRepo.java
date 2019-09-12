package com.example.demo.data_access_object;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitymodels.OptionEntity;

public interface OptionRepo extends JpaRepository<OptionEntity, Integer>{

}
