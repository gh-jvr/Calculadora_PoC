package sanitas.poc.calculadora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Clase de configuración del Swagger.
 */
@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    /**
     * Método principal de configuración del Swagger.
     * @return El Docket de configuración del Swagger.
     */
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }

    /**
     * Método de redireccionamiento de rutas hacia el Swagger.
     * @param registry Registro interno de Spring de redireccionamientos.
     */
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/swagger-ui/");
        registry.addRedirectViewController("/swagger-ui", "/swagger-ui/");
        registry.addRedirectViewController("/calculadora", "/swagger-ui/");
    }

}
