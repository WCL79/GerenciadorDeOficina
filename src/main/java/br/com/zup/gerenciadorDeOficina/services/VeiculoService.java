package br.com.zup.gerenciadorDeOficina.services;

import br.com.zup.gerenciadorDeOficina.exceptions.ChassiException;
import br.com.zup.gerenciadorDeOficina.exceptions.ListaVeiculoVazia;
import br.com.zup.gerenciadorDeOficina.exceptions.VeiculoDuplicadoExcecao;
import br.com.zup.gerenciadorDeOficina.models.Veiculo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoService {

    private List<Veiculo> veiculos = new ArrayList<>();

    public Veiculo cadastrar(Veiculo veiculo) {
        validarChassi(veiculo);
        if (veiculos.contains(veiculo)) {
            throw new VeiculoDuplicadoExcecao("o veículo com chassi " + veiculo.getChassi() + " já existe no sistema!");
        }
        veiculos.add(veiculo);
        return veiculo;
    }

    public Veiculo pesquisarChassi(String chassi) {
        Veiculo resultadoVeiculo = null;
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getChassi().equals(chassi)) {
                resultadoVeiculo = veiculo;
            }
        }
        if (resultadoVeiculo == null) {
            throw new ChassiException("Chassi não encontrado");
        }
        return resultadoVeiculo;
    }

    public List<Veiculo> listarTodosVeiculos() {
        if (veiculos.size() == 0) {
            throw new ListaVeiculoVazia("Não existe nenhum veículo cadastrado!");
        }

        return veiculos;
    }

    public void validarChassi(Veiculo chassi){
        for (Veiculo numChassi : veiculos){
            if (numChassi.getChassi().equals(chassi.getChassi())){
                throw new ChassiException("chassi não localizado");
            }
        }

    }

    public void deletar(String chassi) {
        Veiculo deletar = pesquisarChassi(chassi);
        veiculos.remove(deletar);
    }

}