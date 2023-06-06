package project.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

  private final String devUrl = "http://localhost:8080";

  @Bean
  public OpenAPI myOpenAPI() {
    Server devServer = new Server();
    devServer.setUrl(devUrl);
    devServer.setDescription("Server URL in Development environment");

    Contact contact = new Contact();
    contact.setEmail("Email");
    contact.setName("Name");
    contact.setUrl("https://github.com/a0003121/company_info");

    Info info = new Info()
        .title("Company Info API")
        .version("1.0")
        .contact(contact)
        .description("Company Info API.");

    return new OpenAPI().info(info).servers(List.of(devServer));
  }
}
