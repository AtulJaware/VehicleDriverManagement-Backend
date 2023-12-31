package com.vehicle_driver_management.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(metaData());
    }

     private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Vehicle Driver Management App - Spring Boot Swagger Configuration")
                .description("\"Swagger configuration for Vehicle Driver Management App \"")
                .version("1.1.0")
                .license("Apache 2.0")
                .licenseUrl("\"https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();
    }
    /*For Swagger api doc generation: http://localhost:9091/v2/api-docs
                                   or http://localhost:9091/v3/api-docs*/
    /*For Swagger ui: http://localhost:9091/swagger-ui/
                   or http://localhost:9091/swagger-ui/index.html*/
}
