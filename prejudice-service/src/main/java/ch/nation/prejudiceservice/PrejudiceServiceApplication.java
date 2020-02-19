package ch.nation.prejudiceservice;

import ch.nation.core.clients.config.FeignClientConfig;
import ch.nation.core.clients.config.IncomingRequestLoggingConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"ch.nation.core"})
@ComponentScan(basePackages = {"ch.nation"})
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@Import({IncomingRequestLoggingConfiguration.class, FeignClientConfig.class})

public class PrejudiceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrejudiceServiceApplication.class, args);
    }

}
