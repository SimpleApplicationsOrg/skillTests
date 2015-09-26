package org.simpleapplications.skillsquestions.ui.controller;

import org.simpleapplications.skillsquestions.ui.model.SkillForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChooseController {
	
    @RequestMapping({"/","/choose"})
    public String choose(Model model) {
    	model.addAttribute("skill", new SkillForm());
        return "choose";
    }

}
