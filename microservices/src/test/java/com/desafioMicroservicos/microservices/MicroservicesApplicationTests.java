package com.desafioMicroservicos.microservices;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.desafioMicroservicos.microservices.entity.EnumStatus;
import com.desafioMicroservicos.microservices.entity.Pedido;
import com.desafioMicroservicos.microservices.repository.PedidoRepository;
import com.desafioMicroservicos.microservices.services.ItemPedidoServiceImpl;

@SpringBootTest
class MicroservicesApplicationTests {

	@Autowired
	private ItemPedidoServiceImpl itemPedido;

	@Autowired
	private PedidoRepository repository;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	void createPedido() {
		Pedido p = new Pedido();
		p.setStatus(EnumStatus.CANCELADO);
		repository.save(p);
	}

	@Test
	void validateItemPedido() {
		
		
		
		
	}

}
