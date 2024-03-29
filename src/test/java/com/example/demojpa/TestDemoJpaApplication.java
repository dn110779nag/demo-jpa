package com.example.demojpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestDemoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.from(DemoJpaApplication::main).with(TestDemoJpaApplication.class).run(args);
	}

}
