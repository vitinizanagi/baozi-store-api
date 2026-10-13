package com.bazi.store.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bazi.store.model.pedido;
import com.bazi.store.repository.pedidoRepository;

// Controller REST de pedidos
@RestController
@RequestMapping("/pedidos")
public class pedidoController {

    private final pedidoRepository repository;

    public pedidoController(pedidoRepository repository) {
        this.repository = repository;
    }

    // GET /pedidos -> lista todos
    @GetMapping
    public List<pedido> listar() {
        return repository.findAll();
    }

    // POST /pedidos -> cria um pedido
    @PostMapping
    public pedido criar(@RequestBody pedido pedido) {
        return repository.save(pedido);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<pedido> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<pedido> atualizar(@PathVariable Long id, @RequestBody pedido novo) {
        return repository.findById(id).map(p -> {
            p.setClienteId(novo.getClienteId());
            p.setProdutoId(novo.getProdutoId());
            p.setQuantidade(novo.getQuantidade());
            return ResponseEntity.ok(repository.save(p));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
