package com.desafioMicroservicos.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafioMicroservicos.microservices.entity.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

}
