package com.piivault.PII_Vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.piivault")
@EntityScan(basePackages = "com.piivault.domain")
@EnableJpaRepositories(basePackages = "com.piivault.repository")
public class PiiVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiiVaultApplication.class, args);
	}

}
