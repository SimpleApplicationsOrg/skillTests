package org.simpleapplications.skillsquestions.ui.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnswerTest {

	@Test
	public void testCode() {
		final String TEST = "TEST";
		Answer answer = new Answer();
		answer.setCode(TEST);
		assertTrue("Set/Get code did not work",TEST.equals(answer.getCode()));
	}

	@Test
	public void testText() {
		final String TEST = "TEST";
		Answer answer = new Answer();
		answer.setText(TEST);
		assertTrue("Set/Get text did not work",TEST.equals(answer.getText()));
	}

}
