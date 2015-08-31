package org.simpleapplications.questions;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.neo4j.graphdb.Direction;
import org.simpleapplications.skills.Skill;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Question {

    @GraphId
    private Long id;
    private String code;
    private String text;
    @Fetch @RelatedTo(type = "HAS_ANSWER", direction = Direction.OUTGOING)
    private List<Answer> answers;
    @Fetch @RelatedTo(type = "FOR_SKILL", direction = Direction.OUTGOING)
    private Skill skill;

    public Question() {} 
    
    private void validateAnswers(List<Answer> answers) {
        if (CollectionUtils.isEmpty(answers)) {
            throw new IllegalArgumentException(
                    "Answers ca not be null or empty");
        }
        if (answers.size() < 2) {
            throw new IllegalArgumentException(
                    "It should have at least two questions");
        }
        if (answers.stream().noneMatch(a -> a.isCorrect())) {
            throw new IllegalArgumentException(
                    "It should have at least one correct answer");
        }
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		validateAnswers(answers);
		this.answers = answers;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}


}
