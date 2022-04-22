package br.com.luciano.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.luciano.helpdesk.entity.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
