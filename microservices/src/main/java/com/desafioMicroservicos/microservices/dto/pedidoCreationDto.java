package com.desafioMicroservicos.microservices.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.desafioMicroservicos.microservices.entity.EnumStatus;
import com.desafioMicroservicos.microservices.entity.ItemPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

public class pedidoCreationDto {

	@JsonIgnore
	private LocalDateTime dataHora = LocalDateTime.now();

	@NotNull
	private EnumStatus status;

	@JsonIgnore
	private Long id;

	@JsonIgnore
	List<ItemPedido> Itens;

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemPedido> getItens() {
		return Itens;
	}

	public void setItens(List<ItemPedido> itens) {
		Itens = itens;
	}
}
