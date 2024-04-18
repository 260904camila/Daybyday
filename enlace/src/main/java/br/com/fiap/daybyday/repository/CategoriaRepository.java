package br.com.fiap.daybyday.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.daybyday.model.Servico;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
