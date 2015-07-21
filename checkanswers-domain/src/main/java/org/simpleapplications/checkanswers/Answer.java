package org.simpleapplications.checkanswers;

import org.apache.commons.lang3.Validate;

public class Answer {

	private Long id;
	private String text;
	private boolean correct;
	
	public Answer() {};
	
	public Answer(Long id) {
		Validate.isTrue(id > 0, "Answer Id has to be > 0");
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public String getText() {
		return this.text;
	}

	public boolean isCorrect() {
		return this.correct;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

}
