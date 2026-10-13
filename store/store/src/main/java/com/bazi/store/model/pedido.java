package com.bazi.store.model;

import jakarta.persistence.*;
import lombok.Data;

// Entidade JPA"
@Entity
@Data
public class pedido {

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	// Chave primária
    @Id
    // Id gerado automaticamente pelo banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Id do cliente que fez o pedido
    private Long clienteId;

    // Id do produto comprado 
    private Long produtoId;

    // Quantidade de unidades compradas
    private Integer quantidade;
}
