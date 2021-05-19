package br.com.gerenciadorDeOficina.services;

import br.com.gerenciadorDeOficina.models.Cliente;
import br.com.gerenciadorDeOficina.exceptions.ClienteDuplicadoExcecao;
import br.com.gerenciadorDeOficina.exceptions.ClienteNaoLocalizadoExcecao;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

    public Cliente cadastrarCliente(Cliente cliente){
        if(!clientes.contains(cliente)){
            clientes.add(cliente);
            return cliente;
        }
        throw new ClienteDuplicadoExcecao("O CPF " + cliente.getId() + " e e-mail " + cliente.getEmail() +
                " cliente EXISTENTE!");
    }

    public Cliente pesquisarPeloCpf(Integer id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        throw new ClienteNaoLocalizadoExcecao("Nenhum cliente foi encontrado com  esse ID: " + id);
    }

}