package com.example.gerenciadorsenha.controller;

import com.example.gerenciadorsenha.model.Usuario;
import com.example.gerenciadorsenha.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> findById(@PathVariable("idUsuario") Long idUsuario) {
        return ResponseEntity.ok().body(this.usuarioService.findById(idUsuario));
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> listByAllPage(Pageable pageable) {
        return ResponseEntity.ok().body(this.usuarioService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Usuario usuario) {
        try {
            this.usuarioService.insert(usuario);
            return ResponseEntity.ok().body("Senha cadastrada com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<?> update(@PathVariable Long idUsuario, @RequestBody Usuario usuario) {
        try {
            this.usuarioService.update(idUsuario, usuario);
            return ResponseEntity.ok().body("Usuario atualizada com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<?> delete(@PathVariable Long idUsuario) {
        try {
            this.usuarioService.delete(idUsuario);
            return ResponseEntity.ok().body("Senha deletada com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}