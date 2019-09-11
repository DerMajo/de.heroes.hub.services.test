package de.heroes.hub.microservice.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket booksApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/webresources/.*"))
//                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("heroes-hub-test-service API")
                .description("heroes hub test service")
                .termsOfServiceUrl("https://github.com/DerMajo/de.heroes.hub.microservice.test")
                .contact(new Contact("Mario Bracke", "https://github.com/DerMajo/de.heroes.hub.microservice.test",
                        "mario.bracke@gmx.de"))
                .version("1.0")
                .build();
    }
}