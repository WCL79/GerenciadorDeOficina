package br.com.zup.gerenciadorDeOficina.repositories;

import br.com.zup.gerenciadorDeOficina.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
