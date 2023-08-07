package br.com.gestao.usuarios.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UsuarioSecurityConfig {


	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)  throws Exception {

		return httpSecurity
				.authorizeHttpRequests(auth -> {
					auth.requestMatchers("/gestao-usuario-service/login",
							"/gestao-usuario-service/logout").permitAll();
					auth.anyRequest().authenticated();
				})
				.formLogin(Customizer.withDefaults())
				.oauth2Login(Customizer.withDefaults())
				.oauth2ResourceServer(oauth2 -> oauth2.jwt())
				.build();
	}
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("eduardo")
                .password(passwordEncoder().encode("123senha"))
                .authorities("ADMIN");
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
