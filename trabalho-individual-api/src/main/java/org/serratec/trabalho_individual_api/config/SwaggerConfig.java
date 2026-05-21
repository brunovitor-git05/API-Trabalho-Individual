package org.serratec.trabalho_individual_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI myOpenAPI() {
		Contact contato = new Contact();
		contato.setEmail("bruno@gmail.com");
		contato.setName("Bruno");
		contato.url("https://serratec.org/");
		
		License apacheLicense = new License()
		       .name("Apache License ")
			   .url("http://www.apache.org/licenses/LICENSE-2.0");
		
		
		Info info = new Info()
				.title("API de Plataforma de Cursos Comunitários")
				.version("1.0")
				.contact(contato)
				.description("API para cadastro de cursos comunitários")
				.termsOfService("http://serratec.org/")
				.license(apacheLicense);
				
		return new OpenAPI().info(info);
		       
	}
		
}
