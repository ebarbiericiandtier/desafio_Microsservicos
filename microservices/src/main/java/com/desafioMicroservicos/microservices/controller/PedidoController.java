package com.desafioMicroservicos.microservices.controller;

import java.rmi.ServerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.desafioMicroservicos.microservices.dto.pedidoCreationDto;
import com.desafioMicroservicos.microservices.dto.pedidoUpdateDto;
import com.desafioMicroservicos.microservices.entity.Pedido;
import com.desafioMicroservicos.microservices.services.PedidoServiceImpl;
import com.sun.istack.NotNull;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoServiceImpl service;

	@PostMapping("/salvar")
	@ResponseBody
	public ResponseEntity<Pedido> save(@RequestBody @Validated pedidoCreationDto pedido) throws ServerException {

		try {
			service.save(pedido);
			return new ResponseEntity<Pedido>(HttpStatus.CREATED);
		} catch (IllegalAccessException e) {
			throw new ServerException("Erro durante salvar");
		}
	}

	@PutMapping("/update")
	@ResponseBody
	public ResponseEntity<Pedido> update(@RequestBody @Validated pedidoUpdateDto pedido) throws ServerException {

		try {
			service.update(pedido);
			return new ResponseEntity<Pedido>(HttpStatus.CREATED);
		} catch (IllegalAccessException e) {
			throw new ServerException("Erro durante salvar");
		}
	}

	@GetMapping("/get/{id}")
	@ResponseBody
	public pedidoUpdateDto getPedido(@PathVariable @NotNull Long id) throws ServerException {

		try {
			pedidoUpdateDto created = service.get(id);
			return created;

		} catch (IllegalAccessException e) {
			throw new ServerException("Erro durante salvar");
		}
	}
	

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public ResponseEntity<Pedido> delete(@PathVariable Long id) throws ServerException {

		try {
			service.delete(id);
			return new ResponseEntity<Pedido>(HttpStatus.OK);
		} catch (IllegalAccessException e) {
			throw new ServerException("Erro durante salvar");
		}
	}

}
