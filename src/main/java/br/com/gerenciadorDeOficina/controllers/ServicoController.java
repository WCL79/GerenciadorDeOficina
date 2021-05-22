package br.com.gerenciadorDeOficina.controllers;

import br.com.gerenciadorDeOficina.dtos.entrada.CadastrarServicoDTO;
import br.com.gerenciadorDeOficina.models.Servico;
import br.com.gerenciadorDeOficina.services.FuncionarioService;
import br.com.gerenciadorDeOficina.services.ServicoService;
import br.com.gerenciadorDeOficina.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico cadastrarServico(@RequestBody  @Valid CadastrarServicoDTO cadastrarServicoDTO) {
        return servicoService.cadatrar(cadastrarServicoDTO.converterCadastrarServicoDTOParaServico());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Servico> mostrarTodosServicosDoClientePorCpf(@PathVariable Integer id) throws Exception {
        return (List<Servico>) servicoService.procurarServioPeloID(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarOrdemServico(@PathVariable Integer id){
        try{
            servicoService.deletarOrdemServico(id);
        }catch (RuntimeException erro){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, erro.getMessage());
        }
    }
}