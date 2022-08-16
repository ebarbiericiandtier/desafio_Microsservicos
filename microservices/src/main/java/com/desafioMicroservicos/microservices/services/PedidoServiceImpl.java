package com.desafioMicroservicos.microservices.services;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioMicroservicos.microservices.dto.pedidoCreationDto;
import com.desafioMicroservicos.microservices.dto.pedidoUpdateDto;
import com.desafioMicroservicos.microservices.entity.ItemPedido;
import com.desafioMicroservicos.microservices.entity.Pedido;
import com.desafioMicroservicos.microservices.repository.ItemPedidoRepository;
import com.desafioMicroservicos.microservices.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository repository;

	@Autowired
	private ItemPedidoRepository itemRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void save(pedidoCreationDto pedido) throws IllegalAccessException {
		Pedido entity = modelMapper.map(pedido, Pedido.class);
		repository.save(entity);
	}

	@Override
	public void update(pedidoUpdateDto pedido) throws IllegalAccessException {
		isNull(pedido);
		Pedido entity = modelMapper.map(pedido, Pedido.class);
		repository.save(entity);
	}

	private void isNull(pedidoUpdateDto pedido) throws IllegalAccessException {
		if (pedido == null)
			throw new IllegalAccessException("Pedido não encontrado");
	}

	@Override
	public void delete(Long id) throws IllegalAccessException {
		isNull(id);
		repository.delete(this.repository.findById(id).get());
	}

	private void isNull(Long id) throws IllegalAccessException {
		if (this.repository.findById(id).isEmpty())
			throw new IllegalAccessException("Pedido não encontrado");
	}

	@Override
	public void addItemPedido(pedidoCreationDto pedido, ItemPedido itemPedido) throws IllegalAccessException {

	}

	@Override
	public pedidoUpdateDto get(Long id) throws IllegalAccessException {
		isNull(id);
		return modelMapper.map(repository.findById(id).get(), pedidoUpdateDto.class);
	}

}
