package com.iskool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CourseSubjectMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseSubjectMappingApplication.class, args);
	}

}
