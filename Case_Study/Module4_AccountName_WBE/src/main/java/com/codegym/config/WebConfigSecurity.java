package com.codegym.config;

import com.codegym.service.Impl.login.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Tìm kiếm User trong Database.
        // Và đặt PasswordEncoder.
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // csrf
        http.csrf().disable();

        // login
        http.formLogin()
                .loginProcessingUrl("/checkLogin")
//                .loginPage("/login")
                // login successful
                .defaultSuccessUrl("/")
                // login failed
                .failureUrl("/login/wrong-password")
                // setting username, password
                .usernameParameter("userName")
                .passwordParameter("password")
                // logout
                .and().logout().logoutUrl("/logout")
                // logout successful
                .logoutSuccessUrl("/");

        // authorization
        // guest
//        Các trang không yêu cầu login
//        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/", "/login", "/logout","/employee","/division","/position","/education","/service","/customer").permitAll();

        // Nếu chưa login, nó sẽ redirect tới trang /login.
        http.authorizeRequests().antMatchers("/create-employee","/edit-employee/**","/view-employee/**","/delete-employee/**","/customer/**","/service/**").access("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')");
//
//         Trang chỉ dành cho ADMIN
        http.authorizeRequests().antMatchers("/create-employee","/edit-employee/**","/view-employee/**","/delete-employee/**","/customer/**","/service/**").access("hasRole('ROLE_ADMIN')");
//        http.authorizeRequests().antMatchers().access("hasRole('ROLE_ADMIN')");


        // no permission
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // remember me
        http.rememberMe()
                .rememberMeParameter("rememberMe")
                .rememberMeCookieName("rememberMeCookie")
                .tokenValiditySeconds(60 * 60 * 24 * 7);
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }
}