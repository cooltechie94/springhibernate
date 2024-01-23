package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
//    Swim Coach does not have a @Component. Instead we configured as a spring bean using @Bean
//    @Bean //Bean ID defaults to method name
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
