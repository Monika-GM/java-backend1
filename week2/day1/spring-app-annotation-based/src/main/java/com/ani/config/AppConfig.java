package com.ani.config;


import com.ani.car.Car;
import com.ani.diver.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy

@ComponentScan("com.ani")
@Configuration

public class AppConfig {


    @Bean
    public Driver driver() {
        return new Driver();
    }




}
