package ch.nation.dbservice.config;

import org.springframework.context.annotation.Configuration;
//https://stackoverflow.com/questions/48214783/flyway-spring-boot-autowired-beans-with-jpa-dependency

@Configuration
public class DBFlywayConfiguration {/**extends  FlywayAutoConfiguration.FlywayConfiguration {

 private final SpringUtility utility;

 public DBFlywayConfiguration(FlywayProperties properties, DataSourceProperties dataSourceProperties, ResourceLoader resourceLoader, ObjectProvider<DataSource> dataSource, ObjectProvider<DataSource> flywayDataSource, ObjectProvider<FlywayMigrationStrategy> migrationStrategy, ObjectProvider<FlywayConfigurationCustomizer> fluentConfigurationCustomizers, ObjectProvider<Callback> callbacks, ObjectProvider<FlywayCallback> flywayCallbacks, SpringUtility utility) {
 super(properties, dataSourceProperties, resourceLoader, dataSource, flywayDataSource, migrationStrategy, fluentConfigurationCustomizers, callbacks, flywayCallbacks);


 this.utility = utility;

 }

 @Primary
 @Bean(name = "flywayInitializer")
 @DependsOn("springUtility") public FlywayMigrationInitializer flywayInitializer(Flyway flyway){
 //   return super.flywayInitializer(flyway);
 //return new FlywayMigrationInitializer(flyway, null);

 return new FlywayMigrationInitializer(flyway, (f) ->{} );
 }


 @Bean
 @DependsOn("entityManagerFactory") FlywayMigrationInitializer delayedFlywayInitializer(Flyway flyway) {
 return new FlywayMigrationInitializer(flyway, null);
 }**/

}