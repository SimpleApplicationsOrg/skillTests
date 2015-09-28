package org.simpleapplications.skillsquestions.ui.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SkillFormTest {

	@Test
	public void test() {
		final String NAME = "NAME";
		final String LEVEL = "LEVEL";
		SkillForm form = new SkillForm();
		form.setLevel(LEVEL);
		form.setName(NAME);
		assertTrue("SkillForm not working", NAME.equals(form.getName()) && LEVEL.equals(form.getLevel()));
	}

}
