package br.com.gerenciadorDeOficina.services;

import br.com.gerenciadorDeOficina.models.Servico;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoService {

    private List<Servico> servicos = new ArrayList<>();

    public Servico cadatrar(Servico servico) {
        servicos.add(servico);
        return servico;
    }

    public List<Servico> listarTodosServicosPeloCpfDoCliente(String cpf) throws Exception {
        List<Servico> servicosDoCliente = gerarListaDeServicoPorCpf(cpf);

        if (servicosDoCliente.size() == 0) {
            throw new Exception("nenhum serviço foi localizado com CPF " + cpf + "!");
        }

        return servicosDoCliente;
    }

    private List<Servico> gerarListaDeServicoPorCpf(String cpf) {
        List<Servico> servicosDoCliente = new ArrayList<>();

        for(Servico servico : servicos) {

        }

        return servicosDoCliente;
    }

    public boolean deletarOrdemServico(Integer servico){
        for(Servico ordemServico : servicos){
            if(ordemServico.getOrdemDeServico() == ordemServico.getOrdemDeServico() ){
                servicos.remove(ordemServico);
                return true;
            }
        }
        throw new RuntimeException("Nome não encontrado!");
    }

}


