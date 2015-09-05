package org.simpleapplications.skillsquestions.service.dao;

import java.util.ArrayList;
import java.util.List;

import org.simpleapplications.questions.Question;
import org.simpleapplications.questions.QuestionDao;
import org.simpleapplications.skills.Skill;
import org.simpleapplications.skills.SkillLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDaoImpl implements QuestionDao {

  private QuestionDaoGraph questionDao;

  @Autowired
  public QuestionDaoImpl(QuestionDaoGraph questionDao) {
    this.questionDao = questionDao;
  }

  @Override
  public List<Question> getQuestions(List<Skill> skills) {
    List<Question> questions = new ArrayList<>();
    for (Skill skill : skills) {
      List<Question> questionsGraph = questionDao.getQuestions(skill.getCode(),
          skill.getLevel().toString());
      questions.addAll(questionsGraph);
    }
    return questions;
  }

  @Override
  public List<Question> getQuestions(String skill, SkillLevel skillLevel) {
    return questionDao.getQuestions(skill, skillLevel.toString());
  }

}
