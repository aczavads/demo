package com.example.demo.cor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

@RestController
@RequestMapping("/api/cores")
public class CorController { 
	private List<Cor> cores;

	public CorController() { 
		this.cores = new ArrayList<>(Arrays.asList(new Cor("Azul"), new Cor("Roxo")));
	}

	@GetMapping
	public ResponseEntity<List<Cor>> getCores() {
		return ResponseEntity.ok(this.cores);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCor(@PathVariable String id) {
		this.cores = this.cores.stream().filter(c -> !c.getId().equals(id)).collect(Collectors.toList()); 
	}

}
