package com.ucsal.crud_teste.infrastructure.repository;

import com.ucsal.crud_teste.infrastructure.entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
