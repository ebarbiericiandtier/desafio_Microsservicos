package com.desafioMicroservicos.microservices.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioMicroservicos.microservices.dto.ItemPedidoCreationDto;
import com.desafioMicroservicos.microservices.dto.ItemPedidoUpdateDto;
import com.desafioMicroservicos.microservices.entity.ItemPedido;
import com.desafioMicroservicos.microservices.entity.Pedido;
import com.desafioMicroservicos.microservices.repository.ItemPedidoRepository;
import com.desafioMicroservicos.microservices.repository.PedidoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ItemPedidoServiceImpl implements ItemPedidoService {

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ObjectMapper objectMapper;

	private void isNullPedido(Long id) throws IllegalArgumentException {
		if (this.pedidoRepository.findById(id).isEmpty())
			throw new IllegalArgumentException("Pedido não encontrado");
	}

	@Override
	public void save(Long idPedido, ItemPedidoCreationDto itemPedidoCreationDto) throws IllegalArgumentException {
		Pedido pedido = pedidoRepository.findById(idPedido).get();
		ItemPedido itemPedido = objectMapper.convertValue(itemPedidoCreationDto, ItemPedido.class);
		itemPedido.setPedido(pedido);
		itemPedidoRepository.save(itemPedido);
	}

	@Override
	public void update(ItemPedidoUpdateDto itemPedidoDto) throws IllegalArgumentException {
		ItemPedido itemPedido = objectMapper.convertValue(itemPedidoDto, ItemPedido.class);
		itemPedido.setPedido(itemPedidoRepository.findById(itemPedidoDto.getId()).get().getPedido());
		itemPedidoRepository.save(itemPedido);
	}

	@Override
	public void delete(Long idItemPedido) throws IllegalArgumentException {
		if (itemPedidoRepository.findById(idItemPedido).isPresent())
			itemPedidoRepository.delete(itemPedidoRepository.findById(idItemPedido).get());
	}

}
