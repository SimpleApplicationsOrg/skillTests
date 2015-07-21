package org.simpleapplications.checkanswers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUtils {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TestUtils.class);

	public enum SampleDataType {
		REQUEST, SOURCE
	}

	public static List<Answer> getCorrectCreatedAnswersList() {
		List<Answer> answers = new ArrayList<>();
		answers.add(new Answer(1L));
		return answers;
	}

	public static List<Question> getDataSource(String jsonFileName) {
		File jsonFile = new File(jsonFileName);
		ObjectMapper mapper = new ObjectMapper();
		List<Question> questions = null;
		try {
			questions = mapper.readValue(jsonFile, TypeFactory.defaultInstance()
					.constructCollectionType(List.class, Question.class));
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return questions;
	}

	public static List<Question> getDataSource() {
		List<Question> questions = generateQuestions(20L, SampleDataType.SOURCE);
		/*
		 * ObjectMapper mapper = new ObjectMapper(); File jsonFile = new
		 * File("datasource.json"); try { mapper.writeValue(jsonFile,
		 * questions); } catch (IOException e) { LOGGER.error(e.getMessage(),e);
		 * }
		 */
		return questions;
	}

	public static List<Question> getDataRequest() {
		return getDataSource("answeredQuestionCorrectly.json");
		// generateQuestions(20L, SampleDataType.REQUEST);
	}
	
	public static List<Question> getDataWrongQuestion() {
		return getDataSource("answeredQuestionWrongly.json");
	}
	

	private static List<Question> generateQuestions(Long numberOfQuestions,
			SampleDataType type) {
		List<Question> questions = new ArrayList<>();
		for (Long i = 1L; i < numberOfQuestions + 1L; i++) {
			Question question;
			if (type.equals(SampleDataType.SOURCE)) {
				question = new QuestionBuilder(i)
						.setText("Question number " + i + "?")
						.setAnswers(generateAnswers(type)).build();
			} else {
				question = new QuestionBuilder(i).setAnswers(
						generateAnswers(type)).build();
			}

			questions.add(question);
		}
		return questions;
	}

	private static List<Answer> generateAnswers(SampleDataType type) {
		List<Answer> answers = new ArrayList<>();
		Long correctAnswer = RandomUtils.nextLong(1L, 6L);
		for (Long i = 1L; i < 6L; i++) {
			Boolean correct = correctAnswer.equals(i);
			Answer answer;
			if (type.equals(SampleDataType.SOURCE)) {
				answer = new AnswerBuilder(i)
						.setText("Answer number " + i + "?")
						.setCorrect(correct).build();
			} else {
				answer = new AnswerBuilder(RandomUtils.nextLong(1L, 6L))
						.build();
			}
			answers.add(answer);
			if (type.equals(SampleDataType.REQUEST)) {
				break;
			}
		}
		return answers;
	}

}
