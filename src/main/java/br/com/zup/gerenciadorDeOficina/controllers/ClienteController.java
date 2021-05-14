package br.com.zup.gerenciadorDeOficina.controllers;

import br.com.zup.gerenciadorDeOficina.models.Cliente;
import br.com.zup.gerenciadorDeOficina.repositories.ClienteRepository;
import br.com.zup.gerenciadorDeOficina.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/clientes/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrarCliente(@RequestBody @Valid Cliente cliente){
    //clienteService.cadastrarCliente(cliente);
       Cliente clienteNovo =  this.clienteRepository.save(cliente);
    return clienteNovo;
    }

    @GetMapping("{cpf}/")
    @ResponseStatus(HttpStatus.OK)
    public Cliente pesquisarPeloCpf(@PathVariable String cpf){
        return  clienteService.pesquisarPeloCpf(cpf);
    }

    @DeleteMapping("{cpf}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientePeloCpf(@PathVariable String cpf){
        clienteService.deletarClientePeloCPF(cpf);
    }

    @GetMapping
    public ResponseEntity<List <Cliente>> indexDeLista(){
        List<Cliente> clienteList = this.clienteRepository.findAll();
        return  ResponseEntity.ok(clienteList);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> atualizarClientes(@PathVariable Integer id, @RequestBody  Cliente cliente){
        cliente.setCodCliente(id);
        Cliente clienteAtualizado = this.clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("{cpf}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id){
        this.clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}