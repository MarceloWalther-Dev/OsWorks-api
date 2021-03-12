package com.algaworks.osworks.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteRepository repository;
	
	
	@GetMapping
	public List<Cliente> listar() {
		return repository.findAll();
	}
	
	@GetMapping("/clienteID")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteID) {
		var cliente = repository.findById(clienteID).get();
		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> adiciona(@RequestBody Cliente cliente){
		repository.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	
}
