package com.bazi.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bazi.store.model.produto;

public interface produtoRepository extends JpaRepository<produto, Long> {
}
