package com.ucsal.crud_teste.controller;

import com.ucsal.crud_teste.buisiness.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Usuario> buscarPorEmail(RequestParam String email){
        return ResponseEntity.ok(usuarioService.buscarPorEmail(email));
    }
    @DeleteMapping
    public ResponseEntity<Void> deletarPorEmail(@RequestParam String email){
        usuarioService.deletarPorEmail(email);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorEmail(@RequestParam String email){
        usuarioService.atualizarPorEmail(email);
        Return ResponseEntity.ok;
    }
}
