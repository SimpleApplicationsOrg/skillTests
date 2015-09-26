package org.simpleapplications.skillsquestions.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class SkillsquestionsUiApplication {

    @Bean
    public WebContentInterceptor webContentInterceptor() {
    	WebContentInterceptor interceptor = new WebContentInterceptor();
    	interceptor.setCacheSeconds(0);
    	interceptor.setUseExpiresHeader(true);
    	interceptor.setUseCacheControlHeader(true);
    	interceptor.setUseCacheControlNoStore(true);
    	return interceptor;
    }
	
	public static void main(String[] args) {
        SpringApplication.run(SkillsquestionsUiApplication.class, args);
    }
}
