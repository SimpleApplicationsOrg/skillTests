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
    private String text;
    @Fetch @RelatedTo(type = "HAS_ANSWER", direction = Direction.OUTGOING)
    private List<Answer> answers;
    @Fetch @RelatedTo(type = "FOR_SKILL", direction = Direction.OUTGOING)
    private Skill skill;

    public Question() {} 
    
    public Question(String text, List<Answer> answers, Skill skill) {
        validateText(text);
        validateSkill(skill);
        validateAnswers(answers);
        this.text = text;
        this.answers = answers;
        this.skill = skill;
    }

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

    private void validateSkill(Skill skill) {
        if (skill == null) {
            throw new IllegalArgumentException("Skill can not be null");
        }
    }

    private void validateText(String text) {
        if (StringUtils.isEmpty(text)) {
            throw new IllegalArgumentException("Text can not be null or empty");
        }
    }

    public String getText() {
        return this.text;
    }

    public List<Answer> getAnswers() {
        return this.answers;
    }

    public Skill getSkill() {
        return this.skill;
    }

}
