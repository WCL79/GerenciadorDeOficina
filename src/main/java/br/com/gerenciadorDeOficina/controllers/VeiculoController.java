package br.com.gerenciadorDeOficina.controllers;

import br.com.gerenciadorDeOficina.dtos.entrada.CadastroVeiculoDTO;
import br.com.gerenciadorDeOficina.models.Usuario;
import br.com.gerenciadorDeOficina.models.Veiculo;
import br.com.gerenciadorDeOficina.repositories.VeiculoRepository;
import br.com.gerenciadorDeOficina.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/veiculo")
public class VeiculoController {


    private final VeiculoService veiculoService;
    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoController(VeiculoService veiculoService, VeiculoRepository veiculoRepository) {
        this.veiculoService = veiculoService;
        this.veiculoRepository = veiculoRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo cadastrar(@RequestBody CadastroVeiculoDTO cadastrarVeiculoDTO) {

        return veiculoService.cadastrar(cadastrarVeiculoDTO.converterCadastrarVeiculoDTOParaVeiculo());
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Veiculo> mostrarTodosOsVeiculos() {
        return veiculoService.listarTodosVeiculos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Veiculo> excluirVeiculo(@PathVariable Long id){
        this.veiculoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
