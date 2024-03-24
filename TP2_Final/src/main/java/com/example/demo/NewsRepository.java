package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository <News, Integer>{
	Iterable<News> findByPublisher(Publisher publisher);
	Iterable<News> findBySubscriber(Subscriber subscriber);
	Iterable<News> findBytopic(String topic);
	
	News findByintNews(Integer intNews);
	
	//News findBytopic(String topic);
}
