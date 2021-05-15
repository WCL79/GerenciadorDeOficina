package br.com.zup.gerenciadorDeOficina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.gerenciadorDeOficina.models.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

}
