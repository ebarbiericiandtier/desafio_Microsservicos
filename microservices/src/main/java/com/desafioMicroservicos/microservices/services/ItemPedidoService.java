package com.desafioMicroservicos.microservices.services;

import com.desafioMicroservicos.microservices.dto.ItemPedidoCreationDto;
import com.desafioMicroservicos.microservices.dto.ItemPedidoUpdateDto;

interface ItemPedidoService {

	void update(ItemPedidoUpdateDto itemPedidoDto) throws IllegalArgumentException;

	void delete(Long idItemPedido) throws IllegalArgumentException;

	void save(Long idPedido, ItemPedidoCreationDto itemPedidoCreationDto) throws IllegalArgumentException;
}
