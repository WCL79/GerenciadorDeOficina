package br.com.gerenciadorDeOficina.controllers;

import br.com.gerenciadorDeOficina.dtos.CadastrarVeiculoDTO;
import br.com.gerenciadorDeOficina.models.Cliente;
import br.com.gerenciadorDeOficina.models.Veiculo;
import br.com.gerenciadorDeOficina.services.ClienteService;
import br.com.gerenciadorDeOficina.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/veiculos/")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo cadastrar(@RequestBody @Valid CadastrarVeiculoDTO cadastrarVeiculoDTO) {
        Cliente cliente = clienteService.pesquisarPeloCpf(cadastrarVeiculoDTO.getCpf());
        return veiculoService.cadastrar(cadastrarVeiculoDTO.converterCadastrarVeiculoDTOparaVeiculo(cliente));
    }

    @GetMapping("{chassi}/")
    @ResponseStatus(HttpStatus.OK)
    public Veiculo pesquisarVeiculoPorChassi(@PathVariable String chassi) {
        return veiculoService.pesquisarChassi(chassi);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> mostrarTodosOsVeiculos() {
        return veiculoService.listarTodosVeiculos();
    }

    @DeleteMapping("{chassi}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarVeiculoPeloChassi(@PathVariable String chassi) {
        veiculoService.deletar(chassi);
    }
}
