package org.simpleapplications.checkanswers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.simpleapplications.checkanswers.dao.QuestionDao;
import org.simpleapplications.checkanswers.impl.CheckAnswersImpl;

public class CheckAnswersTest {

  @Test
  public void testCheckAnswers() {
    QuestionDao questionDao = new QuestionDaoMock();
    CheckAnswers checkAnswers = new CheckAnswersImpl(questionDao);
    List<Question> answeredQuestions = TestUtils.getDataRequest();
    List<Question> evaluatedQuestions = checkAnswers
        .evaluate(answeredQuestions);
    assertTrue("Error evaluating answers",
        CollectionUtils.isNotEmpty(evaluatedQuestions));
  }

  @Test
  public void testCreateQuestion() {
    Long questionId = 1L;
    Question question = new Question();
    question.setId(questionId);
    assertTrue("Question creation failed", question.getId().equals(questionId));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateQuestion0() {
    Long questionId = 0L;
    Question question = new Question();
    question.setId(questionId);
    question.getId();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCreateAnswerNegative() {
    Long answerId = -1L;
    Answer answer = new Answer(answerId);
    answer.getId();
  }

  @Test
  public void testCreateAnswer() {
    Long answerId = 1L;
    Answer answer = new Answer(answerId);
    assertTrue("Answer creation failed", answer.getId().equals(answerId));
  }

  @Test(expected = IllegalArgumentException.class)
  public void sestSetAnswersWithNull() {
    Question question = new Question();
    question.setId(1L);
    List<Answer> answers = new ArrayList<>();
    answers.add(null);
    question.setAnswers(answers);
  }

  @Test
  public void testQuestionBuilder() {
    final Long id = 1L;
    QuestionBuilder builder = new QuestionBuilder(id);
    List<Answer> answers = TestUtils.getCorrectCreatedAnswersList();
    builder.setAnswers(answers);
    Question question = builder.build();
    assertTrue("Error building question", question != null
        && question.getId().equals(id) && question.getAnswers().equals(answers));
  }

  @Test
  public void testAnswerBuilder() {
    final Long id = 1L;
    final String code = "Code";
    AnswerBuilder builder = new AnswerBuilder(id);
    builder.setCode(code).setCorrect(true);
    Answer answer = builder.build();
    assertTrue(
        "Error building answer",
        answer != null && answer.getId().equals(id)
            && code.equals(answer.getCode()) && answer.isCorrect());
  }

  @Test
  public void testValidateCorrectAnswer() {
    QuestionDao questionDao = new QuestionDaoMock();
    CheckAnswers checkAnswers = new CheckAnswersImpl(questionDao);
    List<Question> answeredQuestions = TestUtils.getDataRequest();
    List<Question> evaluatedQuestions = checkAnswers
        .evaluate(answeredQuestions);
    assertTrue("Validate answers not woring properly", evaluatedQuestions
        .get(0).getAnswers().get(0).isCorrect());
  }

  @Test
  public void testValidateWrongAnswer() {
    QuestionDao questionDao = new QuestionDaoMock();
    CheckAnswers checkAnswers = new CheckAnswersImpl(questionDao);
    List<Question> answeredQuestions = TestUtils.getDataWrongQuestion();
    List<Question> evaluatedQuestions = checkAnswers
        .evaluate(answeredQuestions);
    assertTrue("Validate answers not woring properly",
        !evaluatedQuestions.get(0).getAnswers().get(0).isCorrect());
  }

  @Test
  public void testNotAddCorrectAnswer() {
    QuestionDao questionDao = new QuestionDaoMock();
    CheckAnswers checkAnswers = new CheckAnswersImpl(questionDao);
    List<Question> answeredQuestions = TestUtils.getDataRequest();
    List<Question> evaluatedQuestions = checkAnswers
        .evaluate(answeredQuestions);
    assertTrue("Add correct answers not woring properly", evaluatedQuestions
        .get(0).getAnswers().size() == 1);
  }

  @Test
  public void testAddWrongAnswer() {
    QuestionDao questionDao = new QuestionDaoMock();
    CheckAnswers checkAnswers = new CheckAnswersImpl(questionDao);
    List<Question> answeredQuestions = TestUtils.getDataWrongQuestion();
    List<Question> evaluatedQuestions = checkAnswers
        .evaluate(answeredQuestions);
    assertTrue("Add correct anwers not working properly", evaluatedQuestions
        .get(0).getAnswers().size() == 2);
  }

}
