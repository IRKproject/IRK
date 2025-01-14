package ru.isu.irk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer  {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Разрешить CORS для всех путей
                .allowedOrigins("http://localhost:4200") // Укажите домен вашего фронтенда
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Разрешенные HTTP-методы
                .allowedHeaders("*") // Разрешить все заголовки
                .allowCredentials(true) // Разрешить передачу куки и авторизационных данных
                .maxAge(3600); // Время кэширования CORS-запросов (в секундах)
    }

    
}
