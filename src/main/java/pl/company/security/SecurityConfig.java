package pl.company.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by wronskip on 11.08.2017.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resources/**", "/static**").permitAll()
                .antMatchers("/companyList**").permitAll()
                .antMatchers("/materialList**").permitAll()
                .antMatchers("/materialDetails**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }

}
