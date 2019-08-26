package ch.nation.unitsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages ={"ch.nation.core"})
@ComponentScan(basePackages = {"ch.nation"})
public class UnitsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitsServiceApplication.class, args);
	}

}
