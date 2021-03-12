package com.algaworks.osworks.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		var cliente = repository.findById(clienteId).get();
		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> adiciona(@Valid @RequestBody Cliente cliente){
		repository.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@Valid @RequestBody Cliente cliente, @PathVariable Long clienteId){
		if(!repository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(clienteId);
		Cliente clienteSave = repository.save(cliente);
		
		return ResponseEntity.ok(clienteSave);
		
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId){
		if(!repository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(clienteId);
		return ResponseEntity.noContent().build();
	}
}
