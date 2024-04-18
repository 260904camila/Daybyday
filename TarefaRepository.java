package br.com.fiap.daybyday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.daybyday.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {


    
}
