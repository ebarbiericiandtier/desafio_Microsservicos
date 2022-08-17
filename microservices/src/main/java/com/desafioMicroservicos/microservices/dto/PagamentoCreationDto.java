package com.desafioMicroservicos.microservices.dto;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.desafioMicroservicos.microservices.entity.FormaDePagamento;
import com.desafioMicroservicos.microservices.entity.Status;
import com.sun.istack.NotNull;

public class PagamentoCreationDto {

	@NotNull
	@Min(value = 0, message = "Aceitamos apenas valores positivos.")
	private BigDecimal valor;

	@NotNull
	@Size(min = 1, max = 100)
	private String nome;

	@NotNull
	@Size(min = 1, max = 100)
	private String numero;

	private String expiracao;

	@NotNull
	@Size(min = 3, max = 3)
	private String codigo;

	@NotNull
	private Status status;

	@NotNull
	private Long pedidoId;

	@Enumerated(EnumType.STRING)
	@NotNull
	private FormaDePagamento formaDePagamento;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getExpiracao() {
		return expiracao;
	}

	public void setExpiracao(String expiracao) {
		this.expiracao = expiracao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

}
