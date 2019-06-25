package ch.nation.dbservice;

import ch.nation.dbservice.config.DBFlywayConfiguration;
import ch.nation.dbservice.config.SpringDataConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"ch.nation.dbservice.entities","ch.nation.dbservice.repositories","ch.nation.dbservice.utils"
,"ch.nation.dbservice.dummyImporter"})
@Import({DBFlywayConfiguration.class,SpringDataConfig.class})
public class DbserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbserviceApplication.class, args);
	}

}
