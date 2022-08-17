package com.desafioMicroservicos.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioMicroservicos.microservices.dto.PagamentoCreationDto;
import com.desafioMicroservicos.microservices.dto.PagamentoUpdateDto;
import com.desafioMicroservicos.microservices.entity.Pagamento;
import com.desafioMicroservicos.microservices.repository.PagamentoRepository;
import com.desafioMicroservicos.microservices.repository.PedidoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PagamentoServiceImp implements PagamentoService {

	@Autowired
	private PagamentoRepository repository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void salvar(PagamentoCreationDto pagamentoDto) throws IllegalArgumentException {
		repository.save(objectMapper.convertValue(pagamentoDto, Pagamento.class));
	}

	@Override
	public void update(PagamentoUpdateDto pagamentoDto) throws IllegalArgumentException {
		isNull(pagamentoDto.getPedidoId());
		Pagamento pagamento = objectMapper.convertValue(pagamentoDto, Pagamento.class);
		pagamento.setPedido(pedidoRepository.findById(pagamentoDto.getPedidoId()).get());
		repository.save(pagamento);
	}

	@Override
	public void delete(Long idPagamento) throws IllegalArgumentException {
		isNull(idPagamento);
		Pagamento pagamento = repository.findById(idPagamento).get();
		repository.delete(pagamento);
	}

	private void isNull(Long idPagamento) {
		if (repository.findById(idPagamento).isEmpty())
			throw new IllegalArgumentException("Pagamento não cadastrado");

	}

}
