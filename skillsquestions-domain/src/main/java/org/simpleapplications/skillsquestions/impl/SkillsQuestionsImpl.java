package org.simpleapplications.skillsquestions.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.Validate;
import org.simpleapplications.questions.Question;
import org.simpleapplications.questions.QuestionDao;
import org.simpleapplications.skills.Skill;
import org.simpleapplications.skills.SkillLevel;
import org.simpleapplications.skillsquestions.SkillsQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkillsQuestionsImpl implements SkillsQuestions {

    private QuestionDao questionDao;

    @Autowired
    public SkillsQuestionsImpl(QuestionDao questionDao) {
        validateQuestionDao(questionDao);
        this.questionDao = questionDao;
    }

    private void validateQuestionDao(QuestionDao questionDao) {
        if (questionDao == null) {
            throw new IllegalArgumentException("QuestionDao can not be null");
        }
    }

    @Override
    public List<Question> getQuestions(List<Skill> skills) {
        validateSkills(skills);
        return questionDao.getQuestions(skills);
    }

    private void validateSkills(List<Skill> skills) {
        if (CollectionUtils.isEmpty(skills)) {
            throw new IllegalArgumentException(
                    "Skills can not be null or empty");
        }
    }

    @Override
    public List<Question> getQuestions(String skill, String level) {
        Validate.notBlank(skill,"Skill can not be null or empty");
        Validate.notBlank(level, "Level can not be null or empty");
        SkillLevel skillLevel = SkillLevel.valueOf(level);
        
        return questionDao.getQuestions(skill,skillLevel);
    }

}
