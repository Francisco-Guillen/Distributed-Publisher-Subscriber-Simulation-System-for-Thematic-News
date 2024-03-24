package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

@Entity
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer intNews;
	@NonNull
	private String topic;
	@NonNull
	private String content;
	 
	@ManyToOne
	private Publisher publisher;

	@ManyToOne
	private Subscriber subscriber;

	public Integer getIntNews() {
		return intNews;
	}

	public void setIntNews(Integer intNews) {
		this.intNews = intNews;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Publisher getList() {
		return publisher;
	}

	public void setList(Publisher publisher) {
		this.publisher = publisher;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}
}
