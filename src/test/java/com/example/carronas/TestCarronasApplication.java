package com.example.carronas;

import org.springframework.boot.SpringApplication;

public class TestCarronasApplication {

    public static void main(String[] args) {
        SpringApplication.from(CarronasApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
