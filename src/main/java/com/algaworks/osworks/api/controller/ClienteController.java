package com.algaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente = new Cliente(1L,"Joao","1111111","joãogmail.com");
		var cliente2 = new Cliente(2L,"Maria","2222222", "mariagmail.com");
		return Arrays.asList(cliente,cliente2);
	}
	
}
