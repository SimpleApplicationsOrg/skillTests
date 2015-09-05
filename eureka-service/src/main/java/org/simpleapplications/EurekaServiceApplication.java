package org.simpleapplications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApplication {

  private static final Logger LOGGER = LoggerFactory
      .getLogger(EurekaServiceApplication.class);

  @Bean
  CommandLineRunner run(@Value("$message") String msg) {
    return args -> LOGGER.info("message = " + msg);
  }

  public static void main(String[] args) {
    SpringApplication.run(EurekaServiceApplication.class, args);
  }
}
