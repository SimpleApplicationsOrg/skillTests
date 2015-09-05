package org.simpleapplications.questions;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Answer {

    @GraphId
    private Long id;
    
    private String code;

    private String text;

    private boolean correct;

    public Answer() {}
    
    public Answer(String code, String text, boolean correct) {
        validateCode(code);
        validateText(text);

        this.code = code;
        this.text = text;
        this.correct = correct;
    }

    private void validateText(String text) {
        if (StringUtils.isEmpty(text)) {
            throw new IllegalArgumentException("Text can not be null or empty");
        }
    }

    private void validateCode(String code) {
        if (StringUtils.isEmpty(code)) {
            throw new IllegalArgumentException("Code can not be null or empty");
        }
    }

    public Long getId() {
    	return this.id;
    }
    
    public String getCode() {
        return this.code;
    }

    public String getText() {
        return this.text;
    }

    public boolean isCorrect() {
        return correct;
    }

}
