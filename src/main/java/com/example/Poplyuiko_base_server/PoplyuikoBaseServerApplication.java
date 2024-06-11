package com.example.Poplyuiko_base_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class PoplyuikoBaseServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(PoplyuikoBaseServerApplication.class);
	}
}
