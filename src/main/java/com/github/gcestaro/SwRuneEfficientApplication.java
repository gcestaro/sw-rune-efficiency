package com.github.gcestaro;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.gcestaro.services.FileStorageService;

@SpringBootApplication
public class SwRuneEfficientApplication implements CommandLineRunner {

	@Resource
	FileStorageService storageService;

	@Override
	public void run(String... arg) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}

	public static void main(String[] args) {
		SpringApplication.run(SwRuneEfficientApplication.class, args);
	}

}
