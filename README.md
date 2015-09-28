# skillTests ![](https://travis-ci.org/SimpleApplicationsOrg/skillTests.svg?branch=master)

Projet to test some spring framework technologies together. Still in progress...

The idea is using as few as possible frameworks in the domains (skillsquestions-domain and checkanswers-domain).
Use some Spring-Cloud components: configuration (configuration-service), eureka (eureka-service), feign and hystrix (skillsquestions-ui). 
Make services available with Spring-Boot and Spring-Web (skillsquestions-service and checkanswers-service).
Make some data available with Spring-Data-Neo4j (skillsquestions-service and checkanswers-service).
Make UI with Spring-Boot, thymeleaf and bootstrap (skillsquestions-ui).

Some links that will explain all the stuff:

- Spring Framework -> http://projects.spring.io/spring-framework/
- Spring Boot -> http://projects.spring.io/spring-boot/
- Spring Cloud -> http://projects.spring.io/spring-cloud/
- Spring Data Neo4j -> http://projects.spring.io/spring-data-neo4j/
- Neo4j -> http://neo4j.com/
- Thymeleaf -> http://www.thymeleaf.org/
- Bootstrap -> http://getbootstrap.com/getting-started/

Todo:
- Add security with Spring Security.
- Manage user session with Spring Session.
- For now, it uses neo4j embedded. Will connect to graphenedb. 
- 
