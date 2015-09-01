package org.simpleapplications.utils;

import java.util.ArrayList;
import java.util.List;

import org.simpleapplications.questions.Answer;
import org.simpleapplications.questions.Question;
import org.simpleapplications.skills.Skill;
import org.simpleapplications.skills.SkillLevel;

public class TestUtils {

    public static Question getGoodQuestion() {
        List<Answer> answers = TestUtils.getGoodAnswers();
        Skill skill = new Skill("Code", "Name", SkillLevel.BEGGINER);
        Question question = new Question("Code");
        question.setText("Text");
        question.setSkill(skill);
        question.setAnswers(answers);
        return question;
    }
    
    public static List<Answer> getGoodAnswers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("Code", "Text", false));
        answers.add(new Answer("Code1", "Text1", true));
        return answers;
    }
    
    public static List<Answer> getBadAnswers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("Code", "Text", false));
        answers.add(new Answer("Code1", "Text1", false));
        return answers;
    }


}
