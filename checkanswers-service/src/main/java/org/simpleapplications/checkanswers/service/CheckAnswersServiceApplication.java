package org.simpleapplications.checkanswers.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.HighlyAvailableGraphDatabaseFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@SpringBootApplication
@ComponentScan(basePackages = "org.simpleapplications")
@EnableNeo4jRepositories
public class CheckAnswersServiceApplication extends Neo4jConfiguration
        implements CommandLineRunner {

    public CheckAnswersServiceApplication() {
        setBasePackage("org.simpleapplications");
    }

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService() {
        return new HighlyAvailableGraphDatabaseFactory()
                .newHighlyAvailableDatabaseBuilder("target/multiplechoice.db")
                .loadPropertiesFromFile("neo4j.properties")
                .newGraphDatabase();

    }

    public static void main(String[] args) {
        SpringApplication.run(CheckAnswersServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ExecutionEngine engine = new ExecutionEngine(getGraphDatabaseService());
        List<String> queries = getQueries("import.cql");
        for (String query : queries) {
            try (Transaction tx = getGraphDatabaseService().beginTx()) {
                System.out.println(engine.execute(query).dumpToString());
                tx.success();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> getQueries(String filename) {
        List<String> lines = null;
        try {
            InputStream is = getClass().getResourceAsStream("/" + filename);
            Reader fileReader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            lines = new ArrayList<String>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
        } catch (IOException io) {
            System.out.println("getQueries() IOException");
        }
        return lines;
    }

}
