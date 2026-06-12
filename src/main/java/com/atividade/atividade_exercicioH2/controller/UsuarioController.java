package com.atividade.atividade_exercicioH2.controller;

import com.atividade.atividade_exercicioH2.model.Usuario;
import com.atividade.atividade_exercicioH2.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor

public class UsuarioController {
    private final UsuarioService service;

    @GetMapping
    public List<Usuario> listar() {
        return  service.listar();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorID(id));
    }
    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        return ResponseEntity.ok(service.salvar(usuario));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario dados){
        return ResponseEntity.ok(service.atualizar(id, dados));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
