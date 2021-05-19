package br.com.gerenciadorDeOficina.repositories;

import br.com.gerenciadorDeOficina.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
