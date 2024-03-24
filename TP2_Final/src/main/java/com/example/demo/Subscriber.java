package com.example.demo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Subscriber implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer subCode;
	
	private String nameSubscriber;
	
	public String subTopic;
	
	@OneToMany
	private List<News> subscriber;

	public Integer getSubCode() {
		return subCode;
	}

	public void setSubCode(Integer subCode) {
		this.subCode = subCode;
	}

	public String getNameSubscriber() {
		return nameSubscriber;
	}

	public void setNameSubscriber(String nameSubscriber) {
		this.nameSubscriber = nameSubscriber;
	}

	public String getSubTopic() {
		return subTopic;
	}

	public void setSubTopic(String subTopic) {
		this.subTopic = subTopic;
	}
}
