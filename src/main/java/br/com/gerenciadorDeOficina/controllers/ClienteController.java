package br.com.gerenciadorDeOficina.controllers;

import br.com.gerenciadorDeOficina.models.Cliente;
import br.com.gerenciadorDeOficina.repositories.ClienteRepository;
import br.com.gerenciadorDeOficina.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente){
        Cliente clienteNovo =  this.clienteRepository.save(cliente);
        return clienteNovo;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> indexDeLista(){
        List<Cliente> clienteList = this.clienteRepository.findAll();
        return  ResponseEntity.ok(clienteList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarClientes(@PathVariable Integer id, @RequestBody  Cliente cliente){
        cliente.setId(id);
        Cliente clienteAtualizado = this.clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id){
        this.clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}