package org.simpleapplications.checkanswers.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.Validate;
import org.simpleapplications.checkanswers.Answer;
import org.simpleapplications.checkanswers.CheckAnswers;
import org.simpleapplications.checkanswers.Question;
import org.simpleapplications.checkanswers.dao.QuestionDao;

public class CheckAnswersImpl implements CheckAnswers {

	private QuestionDao questionDao;

	public CheckAnswersImpl(QuestionDao questionDao) {
		Validate.notNull(questionDao);
		this.questionDao = questionDao;
	}

	@Override
	public List<Question> evaluate(List<Question> answeredQuestions) {

		Validate.isTrue(CollectionUtils.isNotEmpty(answeredQuestions),
				"Answered question can not be empty");
		Validate.notEmpty(answeredQuestions.toArray(),
				"The questions can not be empty");

		answeredQuestions.stream().forEach(a -> validateAnswer(a));
		
		answeredQuestions.stream().forEach(a -> addCorrectAnswers(a));
		

		return answeredQuestions;
	}
	
	void validateAnswer(Question answeredQuestion) {
		List<Answer> correctAnswers = questionDao
				.getCorrectAnswers(answeredQuestion.getId());

		answeredQuestion
				.getAnswers()
				.stream()
				.filter(a -> CollectionUtils.exists(correctAnswers, b -> b
						.getId().equals(a.getId())))
				.forEach(a -> a.setCorrect(true));
		
	}
	
	void addCorrectAnswers(Question answeredQuestion) {
		List<Answer> correctAnswers = questionDao
				.getCorrectAnswers(answeredQuestion.getId());

		correctAnswers
		.stream()
		.filter(a -> !CollectionUtils.exists(
				answeredQuestion.getAnswers(),
				b -> b.getId().equals(a.getId())))
		.forEach(a -> answeredQuestion.getAnswers().add(a));

	}

}
