package com.labseq.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${developer.name}")
    private String name;

    @Value("${developer.linkedin}")
    private String linkedin;

    @Value("${developer.email}")
    private String email;

    @Value("${title.swagger}")
    private String title;

    @Value("${description.swagger}")
    private String description;

    @Value("${license.swagger}")
    private String license;

    @Value("${license.url.swagger}")
    private String licenseUrl;

    @Value("${version.software}")
    private String version;


    @Bean
    public OpenAPI openAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
                .components((new Components().addSecuritySchemes("basicScheme",
                                                                 new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic"))))
                .info(new Info()
                              .contact(new Contact().name(name).email(email).url(linkedin))
                              .title(title)
                              .description(description)
                              .version(version)
                              .termsOfService("Termo de uso: Open Source")
                              .license(new License().name(license))
                );
    }

}
