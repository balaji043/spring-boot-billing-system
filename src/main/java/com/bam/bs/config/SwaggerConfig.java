package com.bam.bs.config;

import com.google.common.base.Predicates;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableAutoConfiguration
@Configuration
public class SwaggerConfig {
   
    @Bean
    public Docket demoApi() {
        return new Docket(DocumentationType.SWAGGER_2)// <3>
                .select()// <4>
                .apis(RequestHandlerSelectors.any())// <5>
                .paths(Predicates.not(PathSelectors.regex("/error.*")))// <6>, regex must be in double quotes.
                .build();
    }
    
}