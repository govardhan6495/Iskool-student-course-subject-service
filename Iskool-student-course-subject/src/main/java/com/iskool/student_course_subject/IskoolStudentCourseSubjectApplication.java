package com.iskool.student_course_subject;

import org.axonframework.boot.autoconfig.KafkaAutoConfiguration;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(exclude = KafkaAutoConfiguration.class, scanBasePackages = {"com.iskool.student_course_subject"})
@EnableEurekaClient
@EnableJpaRepositories(basePackages = {"com.iskool.student_course_subject"})
public class IskoolStudentCourseSubjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(IskoolStudentCourseSubjectApplication.class, args);
	}

	@Bean
	public Mapper getMapper() {
		return new DozerBeanMapper();
	}
	
}
