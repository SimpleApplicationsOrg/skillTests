package org.simpleapplications.skillsquestions.service.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.simpleapplications.questions.Question;
import org.simpleapplications.skillsquestions.SkillsQuestions;
import org.simpleapplications.skillsquestions.service.exception.NoQuestionsFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skillsquestions")
public class SkillsQuestionController {

    private SkillsQuestions multipleChoiceQuestions;

    @Autowired
    public SkillsQuestionController(
            SkillsQuestions multipleChoiceQuestions) {
        this.multipleChoiceQuestions = multipleChoiceQuestions;
    }

    @RequestMapping(value = "/getQuestions/{skill}/{level}", method = RequestMethod.GET)
    public List<Question> getQuestions(
            @PathVariable String skill, @PathVariable String level) {

        List<Question> questions = multipleChoiceQuestions.getQuestions(skill,
                level);

        validateQuestions(questions, skill, level);

        return questions;
    }

    private void validateQuestions(List<Question> questions, String skill,
            String level) {
        if (CollectionUtils.isEmpty(questions)) {
            throw new NoQuestionsFound(String.format(
                    "No questions found for skill %s and level %s", skill,
                    level));
        }
    }

    @ExceptionHandler(NoQuestionsFound.class)
    public ResponseEntity<String> handleNoQuestionsFound(NoQuestionsFound e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
