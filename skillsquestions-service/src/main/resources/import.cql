MATCH (n) OPTIONAL MATCH (n)-[r]-() DELETE n,r;
CREATE (q:Question:_Question { code : 'Question1', text : 'What is the complexity of get in the ArrayList?' });
MATCH (q:Question) CREATE (q)-[:FOR_SKILL]->(s:Skill:_Skill { code : 'JAVA', name : 'Java', level : 'BEGINNER'});
MATCH (q:Question) CREATE (q)-[:HAS_ANSWER]->(a:Answer:_Answer { code : 'CodeAnswer1', text : 'O(1)', correct : true});
MATCH (q:Question) CREATE (q)-[:HAS_ANSWER]->(a:Answer:_Answer { code : 'CodeAnswer2', text : 'O(n)', correct : false});