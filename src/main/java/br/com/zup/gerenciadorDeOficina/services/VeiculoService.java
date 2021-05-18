package br.com.zup.gerenciadorDeOficina.services;

import br.com.zup.gerenciadorDeOficina.exceptions.ChassiException;
import br.com.zup.gerenciadorDeOficina.exceptions.ListaVeiculoVazia;
import br.com.zup.gerenciadorDeOficina.exceptions.VeiculoDuplicadoExcecao;
import br.com.zup.gerenciadorDeOficina.models.Veiculo;
import br.com.zup.gerenciadorDeOficina.repositories.VeiculoRepository;

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
       /* validarChassi(veiculo);
        if (veiculos.contains(veiculo)) {
            throw new VeiculoDuplicadoExcecao("o veículo com chassi " + veiculo.getChassi() + " já existe no sistema!");
        }
        veiculos.add(veiculo);*/
    	Veiculo veiculoCadastrado = this.repository.save(veiculo);
        return veiculoCadastrado;
    }

    
    public List<Veiculo> listarTodosVeiculos() {
       // if (veiculos.size() == 0) {
       //     throw new ListaVeiculoVazia("Não existe nenhum veículo cadastrado!");
       // }
    	List<Veiculo> veiculos = this.repository.findAll();
        return veiculos;
    }
    
    public Veiculo buscaPorId(Integer id) {
    	return  this.repository.findById(id).get();
    }

}