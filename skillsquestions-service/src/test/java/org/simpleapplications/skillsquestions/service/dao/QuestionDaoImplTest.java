package org.simpleapplications.skillsquestions.service.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.simpleapplications.questions.Question;
import org.simpleapplications.skills.Skill;
import org.simpleapplications.skills.SkillLevel;

public class QuestionDaoImplTest {

	@Test
	public void testGetQuestionsListOfSkill() {
		QuestionDaoGraph dao = new QuestionDaoGraphMock();
		QuestionDaoImpl impl = new QuestionDaoImpl(dao);
		List<Question> questions = impl.getQuestions("TEST", SkillLevel.BEGINNER); 
		assertTrue("Get question not working properly",questions.size() == 1);
	}

	@Test
	public void testGetQuestionsStringSkillLevel() {
		QuestionDaoGraph dao = new QuestionDaoGraphMock();
		QuestionDaoImpl impl = new QuestionDaoImpl(dao);
		List<Skill> skills = new ArrayList<>();
		skills.add(new Skill("TEST","TEST","BEGINNER"));
		List<Question> questions = impl.getQuestions(skills);
		assertTrue("Get question not working properly",questions.size() == 1);
		
	}

}
