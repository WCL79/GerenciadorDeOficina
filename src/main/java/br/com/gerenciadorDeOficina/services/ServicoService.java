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

    public List<Servico> listarTodosServicosPelaOrdemDeServico(String os) throws Exception {
        List<Servico> servicosDoCliente = gerarListaDeServicoPorOS(os);

        if (servicosDoCliente.size() == 0) {
            throw new Exception("Não há essa Ordem de Serviço " + os + "!");
        }

        return servicosDoCliente;
    }

    private List<Servico> gerarListaDeServicoPorOS(String cpf) {
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


