//package com.codegym.config;
//
//import com.codegym.service.Impl.login.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        // Tìm kiếm User trong Database.
//        // Và đặt PasswordEncoder.
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // csrf
//        http.csrf().disable();
//
//        // login
//        http.formLogin()
//                .loginProcessingUrl("/checkLogin")
//                .loginPage("/login")
//                // login successful
//                .defaultSuccessUrl("/home")
//                // login failed
//                .failureUrl("/login/wrong-password")
//                // setting username, password
//                .usernameParameter("userName")
//                .passwordParameter("password")
//                // logout
//                .and().logout().logoutUrl("/logout")
//                // logout successful
//                .logoutSuccessUrl("/home");
//
//        // authorization
//        // guest
////        Các trang không yêu cầu login
////        http.authorizeRequests().antMatchers("/login").permitAll();
//        http.authorizeRequests().antMatchers("/", "/login", "/logout","/employee","/division","/position","/education").permitAll();
//
//        // Nếu chưa login, nó sẽ redirect tới trang /login.
//        http.authorizeRequests().antMatchers("/create-employee","/edit-employee/**","/view-employee/**","/delete-employee/**").access("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')");
//
//        // Trang chỉ dành cho ADMIN
//        http.authorizeRequests().antMatchers("/create-employee","/edit-employee/**","/view-employee/**","/delete-employee/**").access("hasRole('ROLE_ADMIN')");
//
//
//        // no permission
//        http.exceptionHandling().accessDeniedPage("/login/no-accessing");
//
//        // remember me
//        http.rememberMe()
//                .rememberMeParameter("rememberMe")
//                .rememberMeCookieName("rememberMeCookie")
//                .tokenValiditySeconds(60 * 60 * 24 * 365 * 25);
//    }
//}