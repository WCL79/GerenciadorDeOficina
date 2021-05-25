package br.com.gerenciadorDeOficina.controllers;

import br.com.gerenciadorDeOficina.models.Servico;
import br.com.gerenciadorDeOficina.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico cadastrarServico(@RequestBody   Servico cadastrarServicoDTO) {
        return servicoService.cadatrar(cadastrarServicoDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Servico> mostrarTodosServicosPeloID(@PathVariable Long id) throws Exception {
        return (List<Servico>) servicoService.procurarServioPeloID(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Servico> excluir(@PathVariable Long id) throws Exception {
        Optional<Servico> cliOptionalServico = Optional.ofNullable(servicoService.procurarServioPeloID(id));
        if(cliOptionalServico.isPresent()) {
            servicoService.deletarOrdemServico(id);
            return 	ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
/*
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarOrdemServico(@PathVariable Long id){
        try{
            servicoService.deletarOrdemServico(id);
        }catch (RuntimeException erro){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, erro.getMessage());
        }
    }*/
}