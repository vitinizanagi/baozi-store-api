package com.bazi.store.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

// Marca a classe como entidade JPA 
@Entity
@Data
public class produto {

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Boolean getEstoque() {
		return estoque;
	}

	public void setEstoque(Boolean estoque) {
		this.estoque = estoque;
	}

	// Chave primária da tabela
    @Id
    // O MySQL gera o id sozinho 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do produto 
    private String nome;

    // Preço unitário. 
    private BigDecimal preco;

    // Indica se esta disponível 
    private Boolean estoque;
}
