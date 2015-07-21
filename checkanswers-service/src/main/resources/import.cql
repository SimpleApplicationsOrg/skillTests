MATCH (n) OPTIONAL MATCH (n)-[r]-() DELETE n,r;
CREATE (q:Question:_Question { text : 'Question' });
MATCH (q:Question) CREATE (q)-[:FOR_SKILL]->(s:Skill:_Skill { code : 'CodeSkill1', name : 'Skill1', level : 'BEGGINER'});
MATCH (q:Question) CREATE (q)-[:HAS_ANSWER]->(a:Answer:_Answer { code : 'CodeAnswer1', text : 'Answer1', correct : true});
MATCH (q:Question) CREATE (q)-[:HAS_ANSWER]->(a:Answer:_Answer { code : 'CodeAnswer2', text : 'Answer2', correct : false});