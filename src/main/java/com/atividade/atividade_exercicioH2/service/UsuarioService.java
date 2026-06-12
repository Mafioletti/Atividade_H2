package com.atividade.atividade_exercicioH2.service;

import com.atividade.atividade_exercicioH2.model.Usuario;
import com.atividade.atividade_exercicioH2.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UsuarioService {
    private final UsuarioRepository repository;

    public List<Usuario> listar(){
        return repository.findAll();
    }
    public Usuario buscarPorID(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
    public Usuario salvar(Usuario usuario){
        return repository.save(usuario);
    }
    public Usuario atualizar(Long id, Usuario dados){
        Usuario usuario = buscarPorID(id);
        usuario.setNome(dados.getNome());
        usuario.setEmail(dados.getEmail());


        return repository.save(usuario);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }
}
