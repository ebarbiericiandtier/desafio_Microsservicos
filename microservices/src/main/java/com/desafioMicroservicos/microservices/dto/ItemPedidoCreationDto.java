package com.desafioMicroservicos.microservices.dto;

import com.sun.istack.NotNull;

public class ItemPedidoCreationDto {

	@NotNull
	private Integer quantidade;

	@NotNull
	private String descricao;

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

}
