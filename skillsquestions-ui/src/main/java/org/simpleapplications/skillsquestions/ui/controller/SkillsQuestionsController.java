package org.simpleapplications.skillsquestions.ui.controller;

import java.util.List;

import org.simpleapplications.skillsquestions.ui.model.Question;
import org.simpleapplications.skillsquestions.ui.model.SkillForm;
import org.simpleapplications.skillsquestions.ui.model.SkillsQuestionsIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SkillsQuestionsController {

    @Autowired
    private SkillsQuestionsIntegration client;
	
	@RequestMapping("/skillsQuestions")
    public String getQuestions(SkillForm skill, Model model) {
    	List<Question> questions = client.getClients(skill.getName(), skill.getLevel());
    	model.addAttribute("questions", questions);
        return "skillsQuestions";
    }
	
}
