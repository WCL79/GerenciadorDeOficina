package br.com.gerenciadorDeOficina.jwt;

import br.com.gerenciadorDeOficina.models.Usuario;
import br.com.gerenciadorDeOficina.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioLoginService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
        usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Email não cadastrado"));
        Usuario usuario = usuarioOptional.get();

        return new UsuarioLogin(usuario.getEmail(), usuario.getSenha(),
                usuario.getNomeCompleto());
    }
}