package com.atividade.atividade_exercicioH2.repository;

import com.atividade.atividade_exercicioH2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
