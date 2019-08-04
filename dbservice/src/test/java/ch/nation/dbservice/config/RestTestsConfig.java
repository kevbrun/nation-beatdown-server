package ch.nation.dbservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@Configuration

public class RestTestsConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
