package org.simpleapplications.service.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigurationServiceApplication {

  private ConfigurationServiceApplication() {
  }

  public static void main(String[] args) {
    SpringApplication.run(ConfigurationServiceApplication.class, args);
  }
}
