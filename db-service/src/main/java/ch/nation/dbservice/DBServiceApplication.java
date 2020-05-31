package ch.nation.dbservice;

import ch.nation.core.config.security.HashEncoderConfig;
import ch.nation.dbservice.config.DBFlywayConfiguration;
import ch.nation.dbservice.config.IncomingRequestLoggingConfiguration;
import ch.nation.dbservice.config.SpringDataConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"ch.nation.dbservice.entities", "ch.nation.dbservice.repositories", "ch.nation.dbservice.utils"
        , "ch.nation.dbservice.dummyImporter", "ch.nation.dbservice.controller"})
@Import({DBFlywayConfiguration.class, SpringDataConfig.class, IncomingRequestLoggingConfiguration.class, HashEncoderConfig.class})
public class DBServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DBServiceApplication.class, args);
    }

}
