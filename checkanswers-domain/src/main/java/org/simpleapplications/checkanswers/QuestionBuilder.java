package org.simpleapplications.checkanswers;

import java.util.List;

public class QuestionBuilder {

	private Question question;
	
	public QuestionBuilder(Long questionId) {
		this.question = new Question(questionId);
	}

	public QuestionBuilder setText(String text) {
		this.question.setText(text);
		return this;
	}

	public QuestionBuilder setAnswers(List<Answer> answers) {
		this.question.setAnswers(answers);
		return this;
	}

	public Question build() {
		return question;
	}
}
