package com.example.univdeptapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("대학 학과 리스트 API")
                        .description("원하는 대학교의 학과 리스트와 로고를 받을 수 있는 API")
                        .version("1.0.0"));
    }
}