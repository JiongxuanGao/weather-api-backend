package com.gaojx.weather.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherApiController {
	private static final Logger log = LoggerFactory.getLogger(WeatherApiController.class);

	@Value("${weather.api.key}")
	private String apiKey;

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", required = false) String name) {
		// say hi
		log.info("hello name=" + name);
		return "Hello " + name;
	}

}
