package com.example.client.clientel.atithi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/v1/atithi")
public class AtithiController {

	private final AtithiService atithiService;

	@Autowired
	public AtithiController(AtithiService atithiService) {
		this.atithiService = atithiService;
	}

	@GetMapping
	public List<Atithi> getAtithis() {
		return atithiService.getAtithis();
	}

	@PostMapping
	public void registerAtithi(@RequestBody Atithi atithi) {
		this.atithiService.addNewAtithi(atithi);
	}

	@DeleteMapping(path = "{atithiId}")
	public void deleteAtithi(@PathVariable("atithiId") String atithiId) {
		this.atithiService.deleteAtithi(atithiId);
	}

	// allows modification of name, plan, token
	@PutMapping(path = "{atithiId}")
	public void updateAtithi(
			@PathVariable("atithiId") String id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String plan,
			@RequestParam(required = false) String token
			) {
		this.atithiService.updateAtithi(id, name, plan, token);
	}
}
