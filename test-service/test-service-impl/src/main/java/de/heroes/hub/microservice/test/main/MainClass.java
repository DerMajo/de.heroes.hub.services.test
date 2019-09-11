package de.heroes.hub.microservice.test.main;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(value = "de.heroes.hub.microservice.test")
@EnableAspectJAutoProxy
public class MainClass {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MainClass.class, args);
    }
}