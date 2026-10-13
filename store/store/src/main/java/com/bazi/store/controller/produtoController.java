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

import com.bazi.store.model.produto;
import com.bazi.store.repository.produtoRepository;

// Controller responde em JSON
@RestController
@RequestMapping("/produtos")
public class produtoController {

    private final produtoRepository repository;

    // Injeção de dependência pelo construtor
    public produtoController(produtoRepository repository) {
        this.repository = repository;
    }

    // GET /produtos -> lista todos
    @GetMapping
    public List<produto> listar() {
        return repository.findAll();
    }

    // POST /produtos -> cria um produto 
    @PostMapping
    public produto criar(@RequestBody produto produto) {
        return repository.save(produto);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<produto> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<produto> atualizar(@PathVariable Long id, @RequestBody produto novo) {
        return repository.findById(id).map(p -> {
            p.setNome(novo.getNome());
            p.setPreco(novo.getPreco());
            p.setEstoque(novo.getEstoque());
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
