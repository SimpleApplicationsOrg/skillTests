package org.simpleapplications.checkanswers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {

  @GraphId
  private Long id;
  private String code;
  @Fetch
  @RelatedTo(type = "HAS_ANSWER", direction = Direction.OUTGOING)
  private List<Answer> answers;

  public void setId(Long id) {
    Validate.isTrue(id > 0, "Id has to be a positive Long");
    this.id = id;
  }

  public Long getId() {
    return this.id;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getCode() {
    return this.code;
  }

  public List<Answer> getAnswers() {
    return this.answers == null ? new ArrayList<Answer>() : this.answers;
  }

  public void setAnswers(List<Answer> answers) {
    Validate.noNullElements(answers.toArray(),
        "Question can not have null answers");
    this.answers = answers;
  }

}
