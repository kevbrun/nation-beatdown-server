package ch.nation.zuul.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class GatewayConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/rest/v1/oauth/**")
                .permitAll()
                //For registering the user
                .antMatchers(HttpMethod.POST, "/api/rest/v1/users").permitAll()
                .antMatchers(HttpMethod.GET, "/api/rest/v1/users/search/identifier**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/rest/v1/users/search/exists**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/rest/v1/users/deep_create").permitAll()
                .antMatchers(HttpMethod.GET, "/api/rest/v1/classes/search/identifier**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/rest/v1/skills/search/identifier**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/rest/v1/prejudices/search/identifier**").permitAll()

                //Allow get All points to be accessed for user registration part
                .antMatchers(HttpMethod.GET, "/api/rest/v1/characteristics**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/rest/v1/classes**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/rest/v1/skills**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/rest/v1/prejudices**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/rest/v1/units/search/exists**").permitAll()

                .antMatchers(HttpMethod.GET, "/api/rest/v1/units/full-name/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/rest/v1/units/first-name/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/rest/v1/units/last-name/**").permitAll()


                //Endpoints used for registering user

                .antMatchers("/**")
                .authenticated();


        //TODO CHECK IF OK WITH AUTH SERVICE
    }
}