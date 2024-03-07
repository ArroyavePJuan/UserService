package com.example.usersservice.infrastructure.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(request -> request.getRequestURI().contains("/auth/authenticate")).permitAll()
                .requestMatchers(request -> request.getRequestURI().contains("/user/email/{email}")).permitAll()
                .antMatchers("/swagger-ui/**", "/users/get-users-token").permitAll()
                .requestMatchers(request -> request.getRequestURI().contains("/user/getId/email/{email}")).permitAll()
                .requestMatchers(request -> request.getRequestURI().contains("/user/saveEmployee")).permitAll()
                .requestMatchers(request -> request.getRequestURI().contains("/auth/saveOwner")).hasAnyAuthority("Admin")
                .requestMatchers(request -> request.getRequestURI().contains("/auth/saveCustomer")).permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
