package org.simpleapplications.questions;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnswerTest {

    @Test
    public void testAnswerCreation() {
        Answer answer = new Answer("code", "Text", false);
        assertTrue("Answer not valid",
                answer.getCode() != null && answer.getText() != null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnswerCreationCodeNull() {
        new Answer(null, "Text", false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnswerCreationTextNull() {
        new Answer("Code", null, false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnswerCreationCodeEmpty() {
        new Answer("", "Text", false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnswerCreationTextEmpty() {
        new Answer("Code", "", false);
    }

}
