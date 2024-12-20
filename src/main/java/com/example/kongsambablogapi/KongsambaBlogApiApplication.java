package com.example.kongsambablogapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KongsambaBlogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KongsambaBlogApiApplication.class, args);
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value= "name", defaultValue="world") String name) {
		return String.format("Hello %s!", name);
	}

}
