package br.com.luciano.helpdesk.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {
	
	@GetMapping("/world")
	public ResponseEntity<String> helloWorld(){
		return ResponseEntity.ok("Hello world");
	}

}
