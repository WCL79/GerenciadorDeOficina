package br.com.gerenciadorDeOficina.services;

import br.com.gerenciadorDeOficina.dtos.entrada.CadastrarServicoDTO;
import br.com.gerenciadorDeOficina.models.Servico;
import br.com.gerenciadorDeOficina.models.Veiculo;
import br.com.gerenciadorDeOficina.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;


    public Servico cadatrar(Servico servico) {
        Servico servico1 = servicoRepository.save(servico);
        return servico1;
    }

    public Servico procurarServioPeloID(Long id) throws Exception {
        Optional<Servico> optionalServico = servicoRepository.findById(id);

        if (optionalServico.isEmpty()) {
            throw new Exception("Ordem de Serviço com id " + id + " não existe!");
        }
        return optionalServico.get();
    }
    public void deletarOrdemServico(Long id) {
        servicoRepository.deleteById(id);
    }

    public Servico atualizar(Long id, Servico servico) throws Exception {
        Servico servicoAtualizar = procurarServioPeloID(id);
        servicoAtualizar.setItem(servico.getItem());
        servicoAtualizar.setOs(servico.getOs());
        servicoAtualizar.setIdVeiculo(servico.getIdVeiculo());
        servicoAtualizar.setMecanica(servico.getMecanica());
        servicoAtualizar.setDataCriacao(servico.getDataCriacao());
        servicoAtualizar.setValor(servico.getValor());

        return servicoRepository.save(servicoAtualizar);
    }
}


