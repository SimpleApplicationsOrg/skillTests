package org.simpleapplications.checkanswers;

import org.apache.commons.lang3.Validate;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Answer {

  @GraphId
  private Long id;
  private String code;
  private boolean correct;

  public Answer() {
  }

  public Answer(Long id) {
    Validate.isTrue(id > 0, "Answer Id has to be > 0");
    this.id = id;
  }

  public Long getId() {
    return this.id;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public boolean isCorrect() {
    return this.correct;
  }

  public void setCorrect(boolean correct) {
    this.correct = correct;
  }

}
