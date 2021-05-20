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
@RequestMapping("/servicos/")
public class ServicoController {


    private final ServicoService servicoService;
    private final VeiculoService veiculoService;

    @Autowired
    public ServicoController(ServicoService servicoService, VeiculoService veiculoService) {
        this.servicoService = servicoService;
        this.veiculoService = veiculoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico cadastrarServico(@RequestBody  @Valid CadastrarServicoDTO cadastrarServicoDTO) {
        return servicoService.cadatrar(cadastrarServicoDTO.converterCadastrarServicoDTOParaServico());
    }

    @GetMapping("{ordemServico}")
    @ResponseStatus(HttpStatus.OK)
    public List<Servico> mostrarTodosServicosDoClientePorCpf(@PathVariable String os) throws Exception {
        return servicoService.listarTodosServicosPelaOrdemDeServico(os);
    }

    @DeleteMapping("{ordemServico}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarOrdemServico(@PathVariable Integer ordemServico){

        try{
            servicoService.deletarOrdemServico(ordemServico);
        }catch (RuntimeException erro){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, erro.getMessage());
        }
    }
}