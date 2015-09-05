package org.simpleapplications.skills;

import static org.junit.Assert.*;

import org.junit.Test;
import org.simpleapplications.skills.Skill;
import org.simpleapplications.skills.SkillLevel;

public class SkillTest {

    @Test
    public void testIsValid() {
        Skill skill = new Skill("skill.code", "Skill Name", SkillLevel.BEGGINER);
        assertTrue(
                "Skill is not valid",
                skill.getCode() != null && skill.getName() != null
                        && skill.getLevel() != null);
    }

    @Test
    public void testIsValidLevelString() {
        Skill skill = new Skill("skill.code", "Skill Name", "BEGGINER");
        assertTrue(
                "Skill is not valid",
                skill.getCode() != null && skill.getName() != null
                        && skill.getLevel() != null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCodeNull() {
        new Skill(null, "Skill Name", SkillLevel.INTERMEDIATE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSkillNull() {
        new Skill("skill.code", null, SkillLevel.BEGGINER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCodeBlank() {
        new Skill("", "Skill Name", SkillLevel.BEGGINER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSkillBlank() {
        new Skill("skill.code", "", SkillLevel.INTERMEDIATE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSkillLevelEmpty() {
        new Skill("skill.code", "Skill Name", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSkillLevelIncorrect() {
        new Skill("skill.code", "Skill Name", "Test");
    }

}
