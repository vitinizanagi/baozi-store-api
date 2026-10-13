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

import com.bazi.store.model.cliente;
import com.bazi.store.repository.clienteRepository;


@RestController
@RequestMapping("/clientes")
public class clienteController {

    private final clienteRepository repository;

    public clienteController(clienteRepository repository) {
        this.repository = repository;
    }

    // GET /clientes -> lista todos
    @GetMapping
    public List<cliente> listar() {
        return repository.findAll();
    }

    // POST /clientes -> cria um cliente
    @PostMapping
    public cliente criar(@RequestBody cliente cliente) {
        return repository.save(cliente);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<cliente> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<cliente> atualizar(@PathVariable Long id, @RequestBody cliente novo) {
        return repository.findById(id).map(c -> {
            c.setNome(novo.getNome());
            c.setClienteDesde(novo.getClienteDesde());
            return ResponseEntity.ok(repository.save(c));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
