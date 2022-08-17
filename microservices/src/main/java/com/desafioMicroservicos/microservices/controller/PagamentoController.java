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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.desafioMicroservicos.microservices.dto.PagamentoCreationDto;
import com.desafioMicroservicos.microservices.entity.Pedido;
import com.desafioMicroservicos.microservices.services.PagamentoServiceImp;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	private PagamentoServiceImp pagamentoService;

	@PostMapping
	@RequestMapping("/salvar")
	private ResponseEntity<PagamentoCreationDto> salvar(@RequestBody @Validated PagamentoCreationDto pagamento) {
		try {
			pagamentoService.salvar(pagamento);
			return new ResponseEntity<PagamentoCreationDto>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<PagamentoCreationDto>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public ResponseEntity<PagamentoCreationDto> delete(@PathVariable Long id) throws ServerException {

		try {
			pagamentoService.delete(id);
			return new ResponseEntity<PagamentoCreationDto>(HttpStatus.OK);
		} catch (Exception e) {
			throw new ServerException("Erro durante salvar");
		}
	}

}
