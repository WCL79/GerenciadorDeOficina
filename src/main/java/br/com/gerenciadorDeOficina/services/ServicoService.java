package br.com.gerenciadorDeOficina.services;

import br.com.gerenciadorDeOficina.models.Servico;
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
        return servico;
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
}


