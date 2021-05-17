package br.com.gerenciadorDeOficina.repositories;


import br.com.gerenciadorDeOficina.models.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

}
