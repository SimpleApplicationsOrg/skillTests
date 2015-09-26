package org.simpleapplications.skillsquestions;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.simpleapplications.questions.QuestionDao;
import org.simpleapplications.skills.Skill;
import org.simpleapplications.skills.SkillLevel;
import org.simpleapplications.skillsquestions.SkillsQuestions;
import org.simpleapplications.skillsquestions.impl.SkillsQuestionsImpl;
import org.simpleapplications.utils.QuestionDaoMock;

public class SkillsQuestionsTest {

  @Test
  public void multipleChoiceCreation() {
    QuestionDao questionDao = new QuestionDaoMock();
    SkillsQuestions multipleChoice = new SkillsQuestionsImpl(questionDao);
    assertTrue("MultipleChoiceQuestions created incorrectly",
        multipleChoice != null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void multipleChoiceCreationDaoNull() {
    new SkillsQuestionsImpl(null);
  }

  @Test
  public void multipleChoiceCreationGetQuestionsBegginer() {
    QuestionDao questionDao = new QuestionDaoMock();
    SkillsQuestions multipleChoice = new SkillsQuestionsImpl(questionDao);
    assertTrue(
        "getQuestions didn't work!",
        multipleChoice.getQuestions(this.getSkillsBegginer()).stream()
            .map(a -> a.getSkill().getLevel())
            .allMatch(a -> a.equals(SkillLevel.BEGINNER)));
  }

  @Test
  public void multipleChoiceCreationGetQuestionIntermediate() {
    QuestionDao questionDao = new QuestionDaoMock();
    SkillsQuestions multipleChoice = new SkillsQuestionsImpl(questionDao);
    assertTrue(
        "getQuestions didn't work!",
        multipleChoice.getQuestions(this.getSkillsItermediate()).stream()
            .map(a -> a.getSkill().getLevel())
            .allMatch(a -> a.equals(SkillLevel.INTERMEDIATE)));
  }

  @Test
  public void multipleChoiceCreationGetQuestionMixed() {
    QuestionDao questionDao = new QuestionDaoMock();
    SkillsQuestions multipleChoice = new SkillsQuestionsImpl(questionDao);
    List<Skill> mixedSkills = getSkillsBegginer();
    mixedSkills.addAll(getSkillsItermediate());
    assertTrue("getQuestions didn't work!",
        multipleChoice.getQuestions(mixedSkills).size() == 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void multipleChoiceCreationGetQuestionsNull() {
    QuestionDao questionDao = new QuestionDaoMock();
    SkillsQuestions multipleChoice = new SkillsQuestionsImpl(questionDao);
    multipleChoice.getQuestions(null);
  }

  @Test
  public void getQuestionsSimple() {
    QuestionDao questionDao = new QuestionDaoMock();
    SkillsQuestions multipleChoice = new SkillsQuestionsImpl(questionDao);
    assertTrue(
        "getQuestions didn't work!",
        multipleChoice.getQuestions("Code1", "BEGINNER").stream()
            .map(a -> a.getSkill().getLevel())
            .allMatch(a -> a.equals(SkillLevel.BEGINNER)));
  }

  private List<Skill> getSkillsBegginer() {
    List<Skill> skills = new ArrayList<>();
    skills.add(new Skill("Code1", "Name1", SkillLevel.BEGINNER));
    skills.add(new Skill("Code2", "Name2", SkillLevel.BEGINNER));
    return skills;
  }

  private List<Skill> getSkillsItermediate() {
    List<Skill> skills = new ArrayList<>();
    skills.add(new Skill("Code1", "Name1", SkillLevel.INTERMEDIATE));
    skills.add(new Skill("Code2", "Name2", SkillLevel.INTERMEDIATE));
    return skills;
  }

}
