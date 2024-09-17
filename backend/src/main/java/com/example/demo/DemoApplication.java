package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public Map<String, String> hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		HashMap<String, String> result = new HashMap<>();
		result.put("success", "true");
		result.put("message", String.format("Hello %s!", name));
		return result;
	}

	@PostMapping("/add")
	public Map<String, Object> add(@RequestBody CalculationParams body) {
		HashMap<String, Object> result = new HashMap<>();
		result.put("success", "true");
		result.put("result", Calculator.add(body.getFirst(), body.getSecond()));
		return result;
	}

	@PostMapping("/subtract")
	public Map<String, Object> subtract(@RequestBody CalculationParams body) {
		HashMap<String, Object> result = new HashMap<>();
		result.put("success", "true");
		result.put("result", Calculator.subtract(body.getFirst(), body.getSecond()));
		return result;
	}

	@PostMapping("/multiply")
	public Map<String, Object> multiply(@RequestBody CalculationParams body) {
		HashMap<String, Object> result = new HashMap<>();
		result.put("success", "true");
		result.put("result", Calculator.multiply(body.getFirst(), body.getSecond()));
		return result;
	}

	@PostMapping("/divide")
	public Map<String, Object> divide(@RequestBody CalculationParams body) {
		HashMap<String, Object> result = new HashMap<>();
		result.put("success", "true");
		result.put("result", Calculator.divide(body.getFirst(), body.getSecond()));
		return result;
	}
}
