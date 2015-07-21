package org.simpleapplications.checkanswers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

public class Question {
	
	private Long id;
	private String text;
	
	private List<Answer> answers;

	public Question() {};
	
	public Question(Long id) {
		Validate.isTrue(id > 0, "Id has to be a positive Long");
		this.setId(id);
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}

	public List<Answer> getAnswers() {
		return this.answers == null ? new ArrayList<Answer>() : this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		Validate.noNullElements(answers.toArray(),"Question can not have null answers");
		this.answers = answers;
	}

}
