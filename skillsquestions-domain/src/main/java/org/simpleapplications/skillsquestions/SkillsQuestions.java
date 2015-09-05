package org.simpleapplications.skillsquestions;

import java.util.List;

import org.simpleapplications.questions.Question;
import org.simpleapplications.skills.Skill;

public interface SkillsQuestions {

  List<Question> getQuestions(List<Skill> skills);

  List<Question> getQuestions(String skill, String level);

}
