package br.com.workshop.agendabackendapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        scanBasePackages = {"br.com.workshop"}
)
@EntityScan(basePackages = {"br.com.workshop", "org.springframework.data.jpa.convert.threeten"})
@EnableJpaRepositories("br.com.workshop")
public class AgendaBackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaBackendApiApplication.class, args);
	}
}
