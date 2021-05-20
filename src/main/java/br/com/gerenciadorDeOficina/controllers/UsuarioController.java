package br.com.gerenciadorDeOficina.controllers;

import br.com.gerenciadorDeOficina.dtos.entrada.CadastarUsuarioDTO;
import br.com.gerenciadorDeOficina.dtos.entrada.CadastrarServicoDTO;
import br.com.gerenciadorDeOficina.models.Servico;
import br.com.gerenciadorDeOficina.models.Usuario;
import br.com.gerenciadorDeOficina.repositories.UsuarioRepository;
import br.com.gerenciadorDeOficina.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository, UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastrarUsuario(@RequestBody CadastarUsuarioDTO cadastarUsuarioDTO) throws Exception {
        return usuarioService.cadastrarNovoUsuario(cadastarUsuarioDTO.converterCadastrarUsuarioDTOParaUsuario());
    }

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> indexDeLista(){
        Iterable<Usuario> clienteList = this.usuarioRepository.findAll();
        return  ResponseEntity.ok(clienteList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarClientes(@PathVariable Long id, @RequestBody  Usuario usuario){
        usuario.setId(id);
        Usuario usuarioAtuaalizado = this.usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioAtuaalizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> excluirCliente(@PathVariable Long id){
        this.usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}