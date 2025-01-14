package ru.isu.irk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import ru.isu.irk.service.IRK_WorkerInfoService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private IRK_WorkerInfoService irkWorkerInfoService; // Внедряем сервис

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/**").permitAll()
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .usernameParameter("username") // Указываем параметр для логина
            .passwordParameter("password") // Указываем параметр для пароля
            .successHandler((request, response, authentication) -> {
                response.setContentType("application/json");
                response.getWriter().write("{\"token\": \"your_jwt_token_here\"}");
                System.out.println("Успешный вход!");
                response.setStatus(HttpStatus.OK.value());
            })
            .failureHandler((request, response, exception) -> {
                response.setContentType("application/json");
                response.getWriter().write("{\"error\": \"Login failed\"}");
                System.out.println("Ошибка входа: " + exception.getMessage());
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
            })
            .permitAll()
        )
        .httpBasic(Customizer.withDefaults());

    return http.build();
}   
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Используем BCrypt для кодирования паролей
    }
    
    

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(irkWorkerInfoService); // Используем внедрённый сервис
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    // @Autowired
    // public void configureGlobal(AuthenticationManagerBuilder auth, AuthenticationProvider authenticationProvider) throws Exception {
    //     auth.authenticationProvider(authenticationProvider); // Внедряем AuthenticationProvider
    // }
}