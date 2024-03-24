package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository <Publisher,  String>{

	Publisher findByCode(long code);
	
	//Publisher findByName(String namePublisher);
}
