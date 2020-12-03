package com.codegym.config;

import com.codegym.aop.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public Logger createLogger() {
        return new Logger();
    }
}
