package org.simpleapplications.checkanswers.dao;

import java.util.List;

import org.simpleapplications.checkanswers.Answer;
import org.simpleapplications.checkanswers.Question;

public interface QuestionDao {

  List<Answer> getCorrectAnswers(String code);

  Question getQuestion(Long id);

  Question getQuestionByCode(String code);

}
