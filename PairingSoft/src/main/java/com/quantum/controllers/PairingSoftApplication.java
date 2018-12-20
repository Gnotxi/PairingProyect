package com.quantum.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.quantum.beans", "com.quantum.controllers"})
public class PairingSoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(PairingSoftApplication.class, args);
	}
}
