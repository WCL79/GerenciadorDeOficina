package br.com.gerenciadorDeOficina.controllers;

import br.com.gerenciadorDeOficina.dtos.entrada.CadastrarUsuarioDTO;
import br.com.gerenciadorDeOficina.models.Usuario;
import br.com.gerenciadorDeOficina.repositories.UsuarioRepository;
import br.com.gerenciadorDeOficina.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("cliente")
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
    @ApiOperation(value = "Cadastrar um novo usuário")
    public void cadastrarNovoUsuario(@RequestBody @Valid CadastrarUsuarioDTO usuario) throws Exception {
        Usuario novoUsuario = usuarioService.cadastrarNovoUsuario(usuario.converterDtoParaModelo());
    }
        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        @ApiOperation(value = "Mostrar todos os usuários")
        public Iterable<CadastrarUsuarioDTO> mostarTodosUsuarios() {
            return CadastrarUsuarioDTO.converterListaDeModeloParaListaDto(usuarioService.obterTodosUsuarios());
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