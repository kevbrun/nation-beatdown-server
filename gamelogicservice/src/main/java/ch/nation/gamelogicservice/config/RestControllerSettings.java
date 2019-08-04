package ch.nation.gamelogicservice.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestControllerSettings {


    @Value("${server.port}")
    private int port;


    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
    webServerFactoryCustomizer() {



        return factory -> {

            factory.setContextPath("/rest/api/v1");
            factory.setPort(port);
            };
    }



}
