package com.ucsal.crud_teste.buisiness;

import com.ucsal.crud_teste.infrastructure.entities.Usuario;
import com.ucsal.crud_teste.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public void salvarUsuario(Usuario usuario) {
        usuarioRepository.saveAndFlush(usuario);
    }

    public Usuario buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
    public void deletarPorEmail(String email){
        usuarioRepository.deleteByEmail(email);
    }
    public void atualizarPorEmail(String email, Usuario usuario){
        Usuario usuarioEntity = buscarPorEmail(email);
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ?
                        usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ?
                        usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();
        usuarioRepository.saveAndFlush(usuarioAtualizado);
    }
}