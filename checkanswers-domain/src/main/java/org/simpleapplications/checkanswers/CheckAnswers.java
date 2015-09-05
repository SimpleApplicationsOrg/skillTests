package org.simpleapplications.checkanswers;

import java.util.List;

public interface CheckAnswers {

  List<Question> evaluate(List<Question> answeredQuestions);

}
