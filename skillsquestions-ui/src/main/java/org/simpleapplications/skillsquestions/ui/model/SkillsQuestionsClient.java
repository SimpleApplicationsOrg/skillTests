package org.simpleapplications.skillsquestions.ui.model;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("skillsquestions-service")
public interface SkillsQuestionsClient {

	@RequestMapping(method = RequestMethod.GET, value = "/skillsquestions/getQuestions/{skill}/{level}")
	List<Question> getQuestions(@PathVariable("skill") String skill, @PathVariable("level") String level);	
}
