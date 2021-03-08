package com.ilgun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFirstConfig {
    @Bean
    public HelloWorld helloWorld(){
        return new HelloWorld();
    }
}
