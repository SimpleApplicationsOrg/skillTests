package org.simpleapplications.questions;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.Validate;
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
    
    public Question(String code) {
		this.setCode(code);
	}

	private void validateAnswers(List<Answer> answers) {
        if(answers == null) {
            throw new NullPointerException(
                    "Answers can not be null");
        }
		if(CollectionUtils. isEmpty(answers)) {
            throw new IllegalArgumentException(
                    "Answers can not be empty");
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
		Validate.notBlank(code,"Code can not be blank");
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		Validate.notBlank(text,"Text can not be blank");
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
		Validate.notNull(skill,"Skill can not be null");
		this.skill = skill;
	}


}
