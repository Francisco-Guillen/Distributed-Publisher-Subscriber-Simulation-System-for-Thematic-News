package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface SubscriberRepository extends CrudRepository <Subscriber,  String>{

	Subscriber findBysubCode(Integer subCode);
	
	Subscriber findBysubTopic(String subTopic);
}

