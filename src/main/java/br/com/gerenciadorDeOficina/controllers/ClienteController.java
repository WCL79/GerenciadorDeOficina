package br.com.gerenciadorDeOficina.controllers;

import br.com.gerenciadorDeOficina.models.Usuario;
import br.com.gerenciadorDeOficina.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) throws Exception {
        Usuario novousuario =  this.usuarioService.cadastrarNovoUsuario(usuario);
        return novousuario;
    }
/*
    @GetMapping
    public ResponseEntity<List<Usuario>> indexDeLista(){
        List<Usuario> clienteList = this.clienteRepository.findAll();
        return  ResponseEntity.ok(clienteList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarClientes(@PathVariable Long id, @RequestBody  Usuario usuario){
        cliente.setId(id);
        Cliente clienteAtualizado = this.clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id){
        this.clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }*/
}