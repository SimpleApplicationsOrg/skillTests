package org.simpleapplications.checkanswers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

public class TestUtils {

  public enum SampleDataType {
    REQUEST, SOURCE
  }

  public static List<Answer> getCorrectCreatedAnswersList() {
    List<Answer> answers = new ArrayList<>();
    answers.add(new Answer(1L));
    return answers;
  }

  public static List<Question> getDataSource(String jsonFileName) {
    File jsonFile = new File(jsonFileName);
    ObjectMapper mapper = new ObjectMapper();
    List<Question> questions = null;
    try {
      questions = mapper.readValue(jsonFile, TypeFactory.defaultInstance()
          .constructCollectionType(List.class, Question.class));
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return questions;
  }

  public static List<Question> getDataSource() {
    List<Question> questions = generateQuestions(20L, SampleDataType.SOURCE);
    return questions;
  }

  public static List<Question> getDataRequest() {
    return getDataSource("answeredQuestionCorrectly.json");
  }

  public static List<Question> getDataWrongQuestion() {
    return getDataSource("answeredQuestionWrongly.json");
  }

  private static List<Question> generateQuestions(Long numberOfQuestions,
      SampleDataType type) {
    List<Question> questions = new ArrayList<>();
    for (Long i = 1L; i < numberOfQuestions + 1L; i++) {
      Question question;
      if (type.equals(SampleDataType.SOURCE)) {
        question = new QuestionBuilder(i).setCode("Code" + i)
            .setAnswers(generateAnswers(type)).build();
      } else {
        question = new QuestionBuilder(i).setAnswers(generateAnswers(type))
            .build();
      }

      questions.add(question);
    }
    return questions;
  }

  private static List<Answer> generateAnswers(SampleDataType type) {
    List<Answer> answers = new ArrayList<>();
    Long correctAnswer = RandomUtils.nextLong(1L, 6L);
    for (Long i = 1L; i < 6L; i++) {
      Boolean correct = correctAnswer.equals(i);
      Answer answer;
      if (type.equals(SampleDataType.SOURCE)) {
        answer = new AnswerBuilder(i).setCode("Answer" + i).setCorrect(correct)
            .build();
      } else {
        answer = new AnswerBuilder(RandomUtils.nextLong(1L, 6L)).build();
      }
      answers.add(answer);
      if (type.equals(SampleDataType.REQUEST)) {
        break;
      }
    }
    return answers;
  }

}
