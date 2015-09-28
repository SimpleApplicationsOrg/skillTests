package org.simpleapplications.skillsquestions.ui.model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class QuestionTest {

	@Test
	public void test() {
		final List<Answer> ANSWERS = new ArrayList<>();
		final String CODE = "CODE";
		final String TEXT = "TEXT";
		Question question = new Question(CODE);
		question.setAnswers(ANSWERS);
		question.setText(TEXT);
		assertTrue("Question not working", CODE.equals(question.getCode()) && TEXT.equals(question.getText())
				&& ANSWERS.equals(question.getAnswers()));
	}
}