package br.com.gerenciadorDeOficina.services;

import br.com.gerenciadorDeOficina.models.Veiculo;
import br.com.gerenciadorDeOficina.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    private List<Veiculo> veiculos = new ArrayList<>();

    public Veiculo cadastrar(Veiculo veiculo) {

        Veiculo veiculoCadastrado = this.repository.save(veiculo);
        return veiculoCadastrado;
    }


    public List<Veiculo> listarTodosVeiculos() {
        List<Veiculo> veiculos = this.repository.findAll();
        return veiculos;
    }

}