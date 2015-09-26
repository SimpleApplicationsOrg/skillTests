package org.simpleapplications.skillsquestions.ui.model;

import java.util.List;

public class Question {

	private String code;
	private String text;
	private List<Answer> answers;

	public Question() {
	}

	public Question(String code) {
		this.setCode(code);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
