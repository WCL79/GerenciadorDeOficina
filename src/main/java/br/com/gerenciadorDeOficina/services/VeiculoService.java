package br.com.gerenciadorDeOficina.services;

import br.com.gerenciadorDeOficina.models.Veiculo;
import br.com.gerenciadorDeOficina.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo cadastrar(Veiculo veiculo) {

        Veiculo veiculoCadastrado = this.veiculoRepository.save(veiculo);
        return veiculoCadastrado;
    }
    public List<Veiculo> listarTodosVeiculos() {
        List<Veiculo> veiculos = this.veiculoRepository.findAll();
        return veiculos;
    }
    public void deletarVeiculo(Long id){
        veiculoRepository.deleteById(id);
    }

    public Veiculo buscarVeiculoPorID(Long id){
        Veiculo veiculo = veiculoRepository.findById(id).get();
        return veiculo;
    }
}