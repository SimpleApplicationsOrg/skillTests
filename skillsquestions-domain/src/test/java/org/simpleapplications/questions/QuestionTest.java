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
        Skill skill = new Skill("Code", "Name", SkillLevel.BEGGINER);
        
        Question question = new Question();
        question.setAnswers(answers);
        question.setSkill(skill);
        assertTrue("Not a valid question", question.getText() != null
                && question.getAnswers() != null && question.getSkill() != null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuestionCretionTextNull() {
        List<Answer> answers = new ArrayList<>();
        Skill skill = new Skill("Code", "Name", SkillLevel.BEGGINER);
        new Question(null, answers, skill);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuestionCretionTextEmpty() {
        List<Answer> answers = new ArrayList<>();
        Skill skill = new Skill("Code", "Name", SkillLevel.BEGGINER);
        new Question("", answers, skill);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuestionCretionSkillNull() {
        List<Answer> answers = new ArrayList<>();
        Skill skill = null;
        new Question("Text", answers, skill);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuestionCretionAnswersNull() {
        List<Answer> answers = null;
        Skill skill = new Skill("Code", "Name", SkillLevel.BEGGINER);
        new Question("Question?", answers, skill);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuestionCretionAnswersEmpty() {
        List<Answer> answers = new ArrayList<>();
        Skill skill = new Skill("Code", "Name", SkillLevel.BEGGINER);
        new Question("Question?", answers, skill);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testQuestionCretionAnswersAllFalse() {
        List<Answer> answers = TestUtils.getBadAnswers();
        Skill skill = new Skill("Code", "Name",SkillLevel.BEGGINER);
        new Question("Question?", answers, skill);
    }


}
