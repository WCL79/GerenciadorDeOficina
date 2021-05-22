package br.com.gerenciadorDeOficina.services;


import br.com.gerenciadorDeOficina.models.Usuario;
import br.com.gerenciadorDeOficina.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Usuario cadastrarNovoUsuario(Usuario usuario) throws Exception {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new Exception("Usuário com e-mail " + usuario.getEmail() + " já cadastrado!");
        }

        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Iterable<Usuario> obterTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario procurarUsuarioPeloId(Long id) throws Exception {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

        if (optionalUsuario.isEmpty()) {
            throw new Exception("O usuário com id " + id + " não existe!");
        }

        return optionalUsuario.get();
    }
    public Usuario procurarUsuarioPeloEmail(String email) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(email);

        if (optionalUsuario.isEmpty()) {
            throw new RuntimeException("Usuário com email " + email + " não localizado!");
        }
        return optionalUsuario.get();
    }
}