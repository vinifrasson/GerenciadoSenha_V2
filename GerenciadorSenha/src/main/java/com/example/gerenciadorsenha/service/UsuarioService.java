package com.example.gerenciadorsenha.service;

import com.example.gerenciadorsenha.model.Usuario;
import com.example.gerenciadorsenha.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findById(Long id){
        return this.usuarioRepository.findById(id).orElse(new Usuario());
    }

    public Page<Usuario> listAll(Pageable pageable){
        return this.usuarioRepository.findAll(pageable);
    }

    @Transactional
    public Usuario insert(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

    @Transactional
    public void update (Long id, Usuario usuario){
        if (id == usuario.getId()){
            this.usuarioRepository.save(usuario);
        }
        else{
            throw new RuntimeException();
        }
    }


    @Transactional
    public void delete(Long id) {
        Optional<Usuario> passw = usuarioRepository.findById(id);
        if (passw.isPresent()){
            this.usuarioRepository.delete(passw.get());
        } else {
            throw new RuntimeException("Senha nao encontrada");
        }
    }
}
