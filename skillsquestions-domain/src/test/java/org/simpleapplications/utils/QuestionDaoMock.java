package org.simpleapplications.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.simpleapplications.questions.Question;
import org.simpleapplications.questions.QuestionDao;
import org.simpleapplications.skills.Skill;
import org.simpleapplications.skills.SkillLevel;

public class QuestionDaoMock implements QuestionDao {

    @Override
    public List<Question> getQuestions(List<Skill> skills) {
        List<Question> questions = new ArrayList<>();
        for (Skill skill : skills) {
            questions.addAll(queryData(skill.getCode(), skill.getLevel()
                    .toString()));
        }
        return questions;
    }

    private List<Question> queryData(String skillCode, String skillLevel) {
        return getData()
                .stream()
                .filter(a -> a.getSkill().getCode().equals(skillCode)
                        && a.getSkill().getLevel().toString()
                                .equals(skillLevel))
                .collect(Collectors.toList());

    }

    private List<Question> getData() {

        Skill skillCode1 = new Skill("Code1", "Name1", SkillLevel.BEGGINER);
        Question question1 = new Question("Question1?",
                TestUtils.getGoodAnswers(), skillCode1);
        Question question2 = new Question("Question2?",
                TestUtils.getGoodAnswers(), skillCode1);

        Skill skillCode2 = new Skill("Code2", "Name2", SkillLevel.INTERMEDIATE);
        Question question3 = new Question("Question1?",
                TestUtils.getGoodAnswers(), skillCode2);
        Question question4 = new Question("Question2?",
                TestUtils.getGoodAnswers(), skillCode2);

        List<Question> questions = new ArrayList<Question>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);

        return questions;
    }

    @Override
    public List<Question> getQuestions(String skill, SkillLevel skillLevel) {
        return queryData(skill, skillLevel.toString());
    }

}
