package org.simpleapplications.checkanswers;

public class AnswerBuilder {

  private Answer answer;

  public AnswerBuilder(Long id) {
    this.answer = new Answer(id);
  }

  public AnswerBuilder setCode(String code) {
    this.answer.setCode(code);
    return this;
  }

  public AnswerBuilder setCorrect(Boolean correct) {
    this.answer.setCorrect(correct);
    return this;
  }

  public Answer build() {
    return this.answer;
  }

}
