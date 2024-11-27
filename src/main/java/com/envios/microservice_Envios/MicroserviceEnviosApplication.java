package com.envios.microservice_Envios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.envios") // Escanea todos los componentes de la aplicacion
@EntityScan(basePackages = "com.envios.entity") // Escanea las entidades
@EnableJpaRepositories(basePackages = "com.envios.repository") //escanea los repositorios

public class MicroserviceEnviosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEnviosApplication.class, args);
	}

}
