package br.com.lottery.betapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("br.com.lottery.betapi.model")
@EnableJpaRepositories("br.com.lottery.betapi.repository")
public class BetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetApiApplication.class, args);
	}

}
