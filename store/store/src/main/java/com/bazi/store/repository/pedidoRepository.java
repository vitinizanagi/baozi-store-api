package com.bazi.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bazi.store.model.pedido;

// Acesso ao banco para a entidade Pedido
public interface pedidoRepository extends JpaRepository<pedido, Long> {
}
