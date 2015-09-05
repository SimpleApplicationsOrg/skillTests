package org.simpleapplications.checkanswers.service.dao;

import org.simpleapplications.checkanswers.Question;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface QuestionDaoGraph extends GraphRepository<Question> {

  Question getQuestionByCode(String code);

}
