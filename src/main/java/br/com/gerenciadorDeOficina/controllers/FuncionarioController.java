package br.com.gerenciadorDeOficina.controllers;

/**
 * Criar uma classe para atribuir o Funcionário.
 */

import br.com.gerenciadorDeOficina.models.Funcionario;
import br.com.gerenciadorDeOficina.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("funcionarios/")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario cadastrarFuncionario (@RequestBody @Valid Funcionario funcionario) throws Exception {
        funcionarioService.cadastrarFuncionario(funcionario);
        return funcionario;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Funcionario> listarTodosFuncionario() {
        return funcionarioService.listarTodosFuncionario();
    }

    @DeleteMapping("{cpf}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletefuncionarioPeloCPF(@PathVariable String cpf) throws Exception {
        funcionarioService.deletarfuncionarioPeloCPF(cpf);
    }
}