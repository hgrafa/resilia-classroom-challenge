package br.com.resilia.smartclasses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SmartclassesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartclassesApplication.class, args);
	}

}
