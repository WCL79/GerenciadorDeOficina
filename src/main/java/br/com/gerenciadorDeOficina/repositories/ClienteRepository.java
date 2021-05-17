package br.com.gerenciadorDeOficina.repositories;

import br.com.gerenciadorDeOficina.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
