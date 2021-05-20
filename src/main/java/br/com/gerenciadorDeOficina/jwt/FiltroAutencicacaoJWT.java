package br.com.gerenciadorDeOficina.jwt;

import br.com.gerenciadorDeOficina.dtos.login.LoginDTO;
import br.com.gerenciadorDeOficina.models.Usuario;
import br.com.gerenciadorDeOficina.services.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class FiltroAutencicacaoJWT extends UsernamePasswordAuthenticationFilter {

    private ComponenteJWT componenteJWT;
    private AuthenticationManager authenticationManager;
    private UsuarioService usuarioService;

    public FiltroAutencicacaoJWT(ComponenteJWT componenteJWT, AuthenticationManager authenticationManager, UsuarioService usuarioService) {
        this.componenteJWT = componenteJWT;
        this.authenticationManager = authenticationManager;
        this.usuarioService = usuarioService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            LoginDTO login = objectMapper.readValue(request.getInputStream(), LoginDTO.class);
            Usuario usuarioLogin = usuarioService.procurarUsuarioPeloEmail(login.getEmail());
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken
                    (login.getEmail(), login.getSenha(), Arrays.asList(
                            new SimpleGrantedAuthority(String.valueOf(usuarioLogin.getEmail()))
                    ));
            Authentication auth = authenticationManager.authenticate(authToken);
            return auth;
        } catch (IOException error) {
            throw new RuntimeException(error.getMessage());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String username = ((UsuarioLogin) authResult.getPrincipal()).getUsername();
        String token = componenteJWT.gerarToken(username);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader("Authorization", "Token "+token);
    }
}
