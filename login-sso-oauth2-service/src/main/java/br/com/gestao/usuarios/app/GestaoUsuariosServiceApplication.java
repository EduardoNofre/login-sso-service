package br.com.gestao.usuarios.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "GESTÃO DE USUARIOS ", version = "1.0",description = " OAUHT 2 GOOGLE "))
@SecurityScheme(name = "bearerToken", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
public class GestaoUsuariosServiceApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(GestaoUsuariosServiceApplication.class, args);
	}

}
