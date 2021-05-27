package br.com.gerenciadorDeOficina.services;

/**
 * Criar uma classe para validar o cadastro do funcionário.
 */

import br.com.gerenciadorDeOficina.models.Funcionario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioService {

    private List<Funcionario> funcionarios = new ArrayList<>();

    public List<Funcionario> listarTodosFuncionario(){
        return funcionarios;
    }

    public Funcionario cadastrarFuncionario(Funcionario funcionario) throws Exception {
        validarCPF(funcionario);
        funcionarios.add(funcionario);
        return funcionario;

    }

    public Funcionario pesquisarPorCpf(String cpf) throws Exception {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }throw new Exception("O funcinário com o CPF " + cpf + " não foi localizado!");
    }

    public void validarCPF(Funcionario funcionario) throws Exception {
        for (Funcionario funcionarioCPF : funcionarios){
            if (funcionarioCPF.getCpf().equals(funcionario.getCpf())){
                throw new Exception("O CPF já esta cadastrado!");
            }
        }
    }

    public void deletarfuncionarioPeloCPF(String cpf) throws Exception {
        Funcionario funcionarioDeletar = pesquisarPorCpf(cpf);
        if (funcionarioDeletar == null) {
            throw new Exception("O funcinário com o CPF " + cpf + " não foi localizado!");
        }

        funcionarios.remove(funcionarioDeletar);
    }

}