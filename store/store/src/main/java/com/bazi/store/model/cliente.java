package com.bazi.store.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

// Entidade JPA
@Entity
@Data
public class cliente {

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

	public LocalDate getClienteDesde() {
		return clienteDesde;
	}

	public void setClienteDesde(LocalDate clienteDesde) {
		this.clienteDesde = clienteDesde;
	}

	// Chave primária
    @Id
    // Id gerado automaticamente pelo banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome 
    private String nome;

    // Data em que o cliente se cadastrou 
    private LocalDate clienteDesde;
}
