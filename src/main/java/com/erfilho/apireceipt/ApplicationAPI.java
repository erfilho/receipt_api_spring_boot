package com.erfilho.apireceipt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationAPI {
    public static void main(String[] args) {
        System.out.println("O projeto está rodando!");
        SpringApplication.run(ApplicationAPI.class, args);
    }
}

