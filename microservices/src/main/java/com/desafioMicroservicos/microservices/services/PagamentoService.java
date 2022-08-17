package com.desafioMicroservicos.microservices.services;

import com.desafioMicroservicos.microservices.dto.PagamentoCreationDto;
import com.desafioMicroservicos.microservices.dto.PagamentoUpdateDto;

public interface PagamentoService {

	void salvar(PagamentoCreationDto pagamentoDto) throws IllegalArgumentException;

	void update(PagamentoUpdateDto pagamentoDto) throws IllegalArgumentException;

	void delete(Long idPagamento) throws IllegalArgumentException;

}
