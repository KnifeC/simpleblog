package moe.keshane.gradleblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SimpleblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleblogApplication.class, args);
	}
}

