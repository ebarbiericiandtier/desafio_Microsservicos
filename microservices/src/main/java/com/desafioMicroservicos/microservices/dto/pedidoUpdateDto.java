package com.desafioMicroservicos.microservices.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.desafioMicroservicos.microservices.entity.EnumStatus;
import com.desafioMicroservicos.microservices.entity.ItemPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

public class pedidoUpdateDto {

	@NotNull
	private Long id;

	@JsonIgnore
	private LocalDateTime dataHora = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	@NotNull
	private EnumStatus status;

	@JsonIgnore
	List<ItemPedido> Itens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<ItemPedido> getItens() {
		return Itens;
	}

	public void setItens(List<ItemPedido> itens) {
		Itens = itens;
	}
}
