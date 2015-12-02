package org.simpleapplications.skillsquestions.service.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.simpleapplications.questions.Question;
import org.simpleapplications.skills.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.neo4j.conversion.Result;

public class QuestionDaoGraphMock implements QuestionDaoGraph {

	@Override
	public Result<Question> findAll() {
		return null;
	}

	@Override
	public Result<Question> findAll(Sort arg0) {
		return null;
	}

	@Override
	public Class<?> getStoredJavaType(Object arg0) {
		return null;
	}

	@Override
	public Result<Question> query(String arg0, Map<String, Object> arg1) {
		return null;
	}

	@Override
	public Page<Question> findAll(Pageable arg0) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void delete(Long arg0) {}

	@Override
	public void delete(Question arg0) {}

	@Override
	public void delete(Iterable<? extends Question> arg0) {}

	@Override
	public void deleteAll() {}

	@Override
	public boolean exists(Long arg0) {
		return false;
	}

	@Override
	public Iterable<Question> findAll(Iterable<Long> arg0) {
		return null;
	}

	@Override
	public Question findOne(Long arg0) {
		return null;
	}

	@Override
	public <S extends Question> S save(S arg0) {
		return null;
	}

	@Override
	public <S extends Question> Iterable<S> save(Iterable<S> arg0) {
		return null;
	}

	@Override
	public List<Question> getQuestions(String skillCode, String level) {
		List<Question> questions = new ArrayList<>();
		Question correct = new Question();
		correct.setSkill(new Skill("TEST","TEST","BEGINNER"));
		questions.add(correct);
		return questions;
	}

	@Override
	public <U extends Question> void saveOnly(U arg0) {}

}
