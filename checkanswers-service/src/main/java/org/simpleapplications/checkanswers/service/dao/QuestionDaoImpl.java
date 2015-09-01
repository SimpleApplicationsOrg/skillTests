package org.simpleapplications.checkanswers.service.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.simpleapplications.checkanswers.Answer;
import org.simpleapplications.checkanswers.Question;
import org.simpleapplications.checkanswers.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	private QuestionDaoGraph questionDao;

	@Autowired
	public QuestionDaoImpl(QuestionDaoGraph questionDao) {
		this.questionDao = questionDao;
	}

	@Override
	public List<Answer> getCorrectAnswers(String code) {
		Question question = getQuestionByCode(code);
		List<Answer> correctAnswers = question.getAnswers().stream()
				.filter(a -> a.isCorrect()).collect(Collectors.toList());
		return correctAnswers;
	}

	@Override
	public Question getQuestion(Long id) {
		return questionDao.findOne(id);
	}

	@Override
	public Question getQuestionByCode(String code) {
		return questionDao.getQuestionByCode(code);
	}

}
