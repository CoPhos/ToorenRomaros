package com.ToorenRomaros.api.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@OpenAPIDefinition(
        info =@Info(
                title = "Cinnabar API",
                version = "1.0",
                contact = @Contact(
                        name = "Jorge Cobos", email = "cobos1932@gmail.com", url = "https://www.JorgeCobos.com"
                ),
                license = @License(
                        name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"
                ),
                description = "${cinnabar.openapi.description}"
        ),
        servers = {
                @Server(url = "${cinnabar.openapi.dev-url}", description = "Development"),
                @Server(url = "${cinnabar.openapi.prod-url}", description = "Production")}
)
public class OpenAPIConfig {
//    @Bean
//    public OpenAPI customizeOpenAPI() {
//        final String securitySchemeName = "bearerAuth";
//        return new OpenAPI()
//                .addSecurityItem(new SecurityRequirement()
//                        .addList(securitySchemeName))
//                .components(new Components()
//                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
//                                .name(securitySchemeName)
//                                .type(SecurityScheme.Type.HTTP)
//                                .scheme("bearer")
//                                .description(
//                                        "Provide the JWT token. JWT token can be obtained from the Login API. For testing, use the credentials <strong>user/password</strong>")
//                                .bearerFormat("JWT")));
//    }
}