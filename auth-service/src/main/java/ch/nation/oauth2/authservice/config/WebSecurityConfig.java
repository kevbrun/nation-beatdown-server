package ch.nation.oauth2.authservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;


    @Value("${nation.db.query.authority-query}")
    private String authorityQuery;
    @Value("${nation.db.query.authorize-query}")
    private String authorizeQuery;


    @Autowired
    public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
       /** auth.inMemoryAuthentication()
                .withUser("john").password(passwordEncoder.encode("123")).roles("USER").and()
                .withUser("tom").password(passwordEncoder.encode("111")).roles("ADMIN").and()
                .withUser("user1").password(passwordEncoder.encode("pass")).roles("USER").and()
                .withUser("admin").password(passwordEncoder.encode("nimda")).roles("ADMIN");
**/



        auth.jdbcAuthentication().dataSource(dataSource)
                .authoritiesByUsernameQuery(authorityQuery)
                .usersByUsernameQuery(authorizeQuery);



    }// @formatter:on

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests()
                .antMatchers("/oauth/**","/api/rest/v1/oauth/**","/**/oauth/**")
                .permitAll()
              //  .antMatchers(HttpMethod.POST,"/users").permitAll()
                .antMatchers("/**")
                .authenticated();
        // @formatter:on
    }

}
