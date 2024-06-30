package ch.state_store_playground.form_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class FormController {
	@Operation(summary = "Greet the user")
	@GetMapping("/api/greeting")
	public String greeting(
			@Parameter(description = "Name of the person to greet") @RequestParam(value = "name", defaultValue = "World") String name) {
		return "Hello " + name;
	}
}