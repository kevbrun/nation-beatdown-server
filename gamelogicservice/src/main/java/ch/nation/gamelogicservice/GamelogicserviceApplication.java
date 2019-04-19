package ch.nation.gamelogicservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableEurekaClient
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableFeignClients(basePackages ={"ch.nation.rest.controller.feign.proxy"})
@ComponentScan(basePackages = {"ch.nation.rest.controller"})
public class GamelogicserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamelogicserviceApplication.class, args);
	}

}
