package com.projeto.processos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig  {
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors()  // Habilitar CORS
            .and()
            .csrf().disable()  // Desabilitar CSRF se necessário
            .authorizeRequests()
            .requestMatchers("/api/**").permitAll()  // Permitir acesso a todas as rotas da API
            .anyRequest().authenticated();  // Outras requisições precisam de autenticação

        return http.build();
    }


}
