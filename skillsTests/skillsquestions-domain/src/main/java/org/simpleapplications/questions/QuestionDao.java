package org.simpleapplications.questions;

import java.util.List;

import org.simpleapplications.skills.Skill;
import org.simpleapplications.skills.SkillLevel;

public interface QuestionDao {

    List<Question> getQuestions(List<Skill> skills);

    List<Question> getQuestions(String skill, SkillLevel skillLevel);

}
