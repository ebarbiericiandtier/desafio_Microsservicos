package com.desafioMicroservicos.microservices.services;

import com.desafioMicroservicos.microservices.dto.pedidoCreationDto;
import com.desafioMicroservicos.microservices.dto.pedidoUpdateDto;
import com.desafioMicroservicos.microservices.entity.ItemPedido;

interface PedidoService {

	void save(pedidoCreationDto pedido) throws IllegalAccessException;

	void update(pedidoUpdateDto pedido) throws IllegalAccessException;

	pedidoUpdateDto get(Long id) throws IllegalAccessException;

	void addItemPedido(pedidoCreationDto pedido, ItemPedido itemPedido) throws IllegalAccessException;

	void delete(Long id) throws IllegalAccessException;

}
