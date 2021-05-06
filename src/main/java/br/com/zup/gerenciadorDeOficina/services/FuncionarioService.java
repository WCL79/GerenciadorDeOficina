package br.com.zup.gerenciadorDeOficina.services;

/**
 * Criar uma classe para validar o cadastro do funcionário.
 */

import br.com.zup.gerenciadorDeOficina.exceptions.FuncionarioExistenteException;
import br.com.zup.gerenciadorDeOficina.exceptions.FuncionarioNaoLocalizadoException;
import br.com.zup.gerenciadorDeOficina.models.Funcionario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioService {

    private List<Funcionario> funcionarios = new ArrayList<>();

    public List<Funcionario> listarTodosFuncionario(){
        return funcionarios;
    }

    public Funcionario cadastrarFuncionario(Funcionario funcionario){
        validarCPF(funcionario);
        funcionarios.add(funcionario);
        return funcionario;

    }

    public Funcionario pesquisarPorCpf(String cpf) throws RuntimeException {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }throw new FuncionarioNaoLocalizadoException("O funcinário com o CPF " + cpf + " não foi localizado!");
    }

    public void validarCPF(Funcionario funcionario) {
        for (Funcionario funcionarioCPF : funcionarios){
            if (funcionarioCPF.getCpf().equals(funcionario.getCpf())){
                throw new FuncionarioExistenteException("O CPF já esta cadastrado!");
            }
        }
    }

    public void deletarfuncionarioPeloCPF(String cpf) {
        Funcionario funcionarioDeletar = pesquisarPorCpf(cpf);
        if (funcionarioDeletar == null) {
            throw new FuncionarioNaoLocalizadoException("O funcinário com o CPF " + cpf + " não foi localizado!");
        }

        funcionarios.remove(funcionarioDeletar);
    }

}