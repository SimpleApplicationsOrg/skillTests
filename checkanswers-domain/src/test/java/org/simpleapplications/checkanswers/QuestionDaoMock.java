package org.simpleapplications.checkanswers;

import java.util.List;
import java.util.stream.Collectors;

import org.simpleapplications.checkanswers.dao.QuestionDao;

public class QuestionDaoMock implements QuestionDao {

  private final List<Question> dataSource = TestUtils
      .getDataSource("datasourcetest.json");

  @Override
  public List<Answer> getCorrectAnswers(String code) {
    List<Answer> correctAnswers = dataSource.stream()
        .filter(a -> a.getCode().equals(code)).map(a -> a.getAnswers())
        .flatMap(a -> a.stream()).filter(a -> a.isCorrect())
        .collect(Collectors.toList());

    return correctAnswers;
  }

  @Override
  public Question getQuestion(Long id) {
    return dataSource.stream().filter(a -> a.getId().equals(id)).findFirst()
        .get();
  }

  @Override
  public Question getQuestionByCode(String code) {
    return dataSource.stream().filter(a -> a.getCode().equals(code))
        .findFirst().get();
  }

}
