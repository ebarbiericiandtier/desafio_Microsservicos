package com.desafioMicroservicos.microservices.controller;

import java.rmi.ServerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.desafioMicroservicos.microservices.dto.ItemPedidoCreationDto;
import com.desafioMicroservicos.microservices.dto.ItemPedidoUpdateDto;
import com.desafioMicroservicos.microservices.entity.Pedido;
import com.desafioMicroservicos.microservices.services.ItemPedidoServiceImpl;

@Controller
@RequestMapping("item")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoServiceImpl service;

	@PostMapping("/salvar/{idPedido}")
	@ResponseBody
	public ResponseEntity<Pedido> save(@PathVariable Long idPedido,
			@RequestBody @Validated ItemPedidoCreationDto pedido) throws ServerException {
		try {

			service.save(idPedido, pedido);
			return new ResponseEntity<Pedido>(HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new ServerException("Erro durante salvar");
		}
	}

	@PutMapping("/atualizar")
	@ResponseBody
	public ResponseEntity<Pedido> update(@RequestBody @Validated ItemPedidoUpdateDto pedido) throws ServerException {
		try {
			service.update(pedido);
			return new ResponseEntity<Pedido>(HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new ServerException("Erro durante salvar");
		}
	}

	@DeleteMapping("/delete/{idItemPedido}")
	@ResponseBody
	public ResponseEntity<Pedido> delete(@PathVariable Long idItemPedido) throws ServerException {
		try {
			service.delete(idItemPedido);
			return new ResponseEntity<Pedido>(HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new ServerException("Erro durante salvar");
		}
	}

}
