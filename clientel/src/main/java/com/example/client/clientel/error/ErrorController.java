package com.example.client.clientel.error;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/error")
public class ErrorController {
	@GetMapping
	public Error errorMsg() {
		return new Error("Unavailable!");
	}
}
