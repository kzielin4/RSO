package pl.eiti.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

import javax.sql.DataSource;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?");
    }

    @Configuration
    @Order(1)
    public static class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().antMatcher("/api").authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
        }
    }

    @Configuration
    @Order(2)
    public static class ApiWebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/hello").access("hasRole('ROLE_ADMIN')")
                    .anyRequest().permitAll()
                    .and()
                    .formLogin().loginPage("/login")
                    .usernameParameter("username").passwordParameter("password")
                    .and()
                    .logout().logoutSuccessUrl("/login?logout")
                    .and()
                    .exceptionHandling().accessDeniedPage("/403")
                    .and()
                    .csrf();
        }
    }


}
