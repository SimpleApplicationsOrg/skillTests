package org.simpleapplications.questions;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.simpleapplications.skills.Skill;
import org.simpleapplications.skills.SkillLevel;
import org.simpleapplications.utils.TestUtils;

public class QuestionTest {

  @Test
  public void testQuestionCretion() {
    List<Answer> answers = TestUtils.getGoodAnswers();
    Skill skill = new Skill("CodeSkill", "Name", SkillLevel.BEGINNER);

    String codeQuestion = "CodeQuestion";
    Question question = new Question(codeQuestion);
    question.setText("Text");
    question.setSkill(skill);
    question.setAnswers(answers);

    assertTrue("Question not properly created",
        codeQuestion.equals(question.getCode()));
  }

  @Test
  public void testSetSkill() {
    Skill skill = new Skill("CodeSkill", "Name", SkillLevel.BEGINNER);

    String codeQuestion = "CodeQuestion";
    Question question = new Question(codeQuestion);
    question.setSkill(skill);

    assertTrue("Skill not properly set", skill.equals(question.getSkill()));
  }

  @Test
  public void testSetText() {
    String codeQuestion = "CodeQuestion";
    Question question = new Question(codeQuestion);
    String text = "Text";
    question.setText(text);

    assertTrue("Text not properly set", text.equals(question.getText()));
  }

  @Test
  public void testSetAnswers() {
    List<Answer> answers = TestUtils.getGoodAnswers();

    String codeQuestion = "CodeQuestion";
    Question question = new Question(codeQuestion);
    question.setAnswers(answers);

    assertTrue("Answers not properly set",
        answers.equals(question.getAnswers()));
  }

  @Test(expected = NullPointerException.class)
  public void testQuestionCretionCodeNull() {
    new Question(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testQuestionCretionCodeBlank() {
    new Question("");
  }

  @Test(expected = NullPointerException.class)
  public void testSetTextNull() {
    Question question = new Question("Code");
    question.setText(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetTextEmpty() {
    Question question = new Question("Code");
    question.setText("");
  }

  @Test(expected = NullPointerException.class)
  public void testQuestionCretionSkillNull() {
    Question question = new Question("Code");
    question.setSkill(null);
  }

  @Test(expected = NullPointerException.class)
  public void testQuestionCretionAnswersNull() {
    Question question = new Question("Code");
    question.setAnswers(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testQuestionCretionAnswersEmpty() {
    List<Answer> answers = new ArrayList<>();
    Question question = new Question("Code");
    question.setAnswers(answers);
  }

}
