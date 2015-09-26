package org.simpleapplications.skillsquestions.ui.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class SkillsQuestionsIntegration {

	@Autowired
	private SkillsQuestionsClient client;

	@HystrixCommand(fallbackMethod = "getClientsFallBack")
	public List<Question> getClients(String name, String level) {
		return client.getQuestions(name, level);
	}
	
	public List<Question> getClientsFallBack(String name, String level) {
		return new ArrayList<Question>();
	}
}
