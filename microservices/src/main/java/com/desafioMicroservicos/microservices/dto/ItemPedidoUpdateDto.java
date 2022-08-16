package com.desafioMicroservicos.microservices.dto;

import com.desafioMicroservicos.microservices.entity.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

public class ItemPedidoUpdateDto {

	@NotNull
	private Long id;

	@NotNull
	private Integer quantidade;

	@NotNull
	private String descricao;

	@JsonIgnore
	private Pedido pedido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
