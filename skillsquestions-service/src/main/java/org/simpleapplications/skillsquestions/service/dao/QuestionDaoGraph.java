package org.simpleapplications.skillsquestions.service.dao;

import java.util.List;

import org.simpleapplications.questions.Question;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface QuestionDaoGraph extends GraphRepository<Question> {

    @Query("MATCH (q:Question)-[:HAS_ANSWER]->(a:Answer),"
            + "(q:Question)-[:FOR_SKILL]->(s:Skill)"
            + " WHERE s.code={0} and s.level={1} RETURN q")
    List<Question> getQuestions(String skillCode, String level);
}
