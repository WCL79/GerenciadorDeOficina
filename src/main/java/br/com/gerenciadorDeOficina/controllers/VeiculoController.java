package br.com.gerenciadorDeOficina.controllers;

import br.com.gerenciadorDeOficina.models.Veiculo;
import br.com.gerenciadorDeOficina.services.ClienteService;
import br.com.gerenciadorDeOficina.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo cadastrar(@RequestBody Veiculo cadastrarVeiculoDTO) {

        return veiculoService.cadastrar(cadastrarVeiculoDTO);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> mostrarTodosOsVeiculos() {
        return veiculoService.listarTodosVeiculos();
    }
}
