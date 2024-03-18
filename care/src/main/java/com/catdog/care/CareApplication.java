package com.catdog.care;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.catdog.care.*") // EmpRepository가 있는 패키지 경로로 수정
public class CareApplication {

	public static void main(String[] args) {
		SpringApplication.run(CareApplication.class, args);
	}

}
