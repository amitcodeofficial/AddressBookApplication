package com.bridgelab.addressbookapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket getBean(){
        return new Docket(DocumentationType.SWAGGER_2).select().paths(regex("/user.*")).
                build().apiInfo(getInfo());
    }

    private ApiInfo getInfo(){
        return new ApiInfoBuilder().title("Address Book API").
                description("This API is created using Spring Boot,JPA,MySQL").license("By Amit Haral").
                build();
    }
}
