package pl.eiti.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;

@Configuration
@EnableWebMvcSecurity
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public WebSecurityConfig() {
        super(true);
    }

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService);
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select USERNAME, PASSWORD, ENABLE from USERS where USERNAME=?")
//                .authoritiesByUsernameQuery(
//                        "select USERNAME, ROLE from USER_ROLES where USERNAME=?");
    }

    @Configuration
    @Order(1)
    public static class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .anonymous().disable()
                    .authorizeRequests()
                    .antMatchers("/oauth/token,/lol").permitAll();
        }
    }

    @Configuration
    @Order(2)
    public static class ApiWebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/login","/lol").permitAll()
                    .antMatchers("/hello").fullyAuthenticated()
                    .anyRequest().permitAll()
                    .antMatchers("/user/**").access("hasRole('ROLE_SERVICE')")
                    .and()
                    .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password")
                    .and()
                    .logout().logoutSuccessUrl("/login?logout")
                    .and()
                    .exceptionHandling().accessDeniedPage("/403")
                    .and()
                    .csrf();
        }
    }


}
