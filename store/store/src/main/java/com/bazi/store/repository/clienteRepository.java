package com.bazi.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bazi.store.model.cliente;

// Acesso ao banco para a entidade Cliente
public interface clienteRepository extends JpaRepository<cliente, Long> {
}
