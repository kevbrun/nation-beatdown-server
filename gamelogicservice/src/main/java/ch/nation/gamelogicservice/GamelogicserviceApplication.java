package ch.nation.gamelogicservice;

import ch.nation.core.clients.config.IncomingRequestLoggingConfiguration;
import ch.nation.core.clients.config.FeignClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableEurekaClient
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableFeignClients(basePackages ={"ch.nation.core.clients"})
@ComponentScan(basePackages = {"ch.nation"})
@Import({IncomingRequestLoggingConfiguration.class,FeignClientConfig.class})
public class GamelogicserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamelogicserviceApplication.class, args);
	}

}
