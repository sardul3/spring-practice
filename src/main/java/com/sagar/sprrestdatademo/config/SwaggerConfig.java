package com.sagar.sprrestdatademo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final Contact DEFAULT_CONTACT = new Contact("Sagar Poudel", "www.sagarpoudel.com", "poudelsagar530@gmail.com");
    public static final ApiInfo DEFAULT_INFO = new ApiInfo("Spring Practice API","Practicing Spring boot" , "1.0.0", "1C", DEFAULT_CONTACT, "Licence @3Q", "wwww.sagarpoudel.com");

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_12).apiInfo(DEFAULT_INFO);
    }
}
