package org.simpleapplications.checkanswers.service.controller;

import java.util.List;

import org.simpleapplications.checkanswers.CheckAnswers;
import org.simpleapplications.checkanswers.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evaluate")
public class CheckAnswersController {

  private CheckAnswers checkAnswers;

  @Autowired
  public CheckAnswersController(CheckAnswers checkAnswers) {
    this.checkAnswers = checkAnswers;
  }

  @RequestMapping(value = "/checkAnswers", method = RequestMethod.POST)
  public List<Question> checkAnswers(
      @RequestBody List<Question> answeredQuestions) {

    return checkAnswers.evaluate(answeredQuestions);
  }

}
