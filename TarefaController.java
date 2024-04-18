package br.com.fiap.daybyday.controller;

import static org.springframework.http.HttpStatus.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.daybyday.model.Tarefa;
import br.com.fiap.daybyday.repository.TarefaRepository;
import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("tarefa")
@Slf4j
public class TarefaController {

    @Autowired // Injeção de Dependência - Inversão de Controle
    TarefaRepository repository;
    
    @GetMapping
    public List<Tarefa> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Tarefa create(@RequestBody Tarefa tarefa){
        log.info("Cadastrando tarefa {}", tarefa);
        return repository.save(tarefa);
    }

    @GetMapping("{id}")
    public ResponseEntity<Tarefa> show(@PathVariable Long id){
        log.info("buscando tarefa com id {}", id);

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("apagando tarefa {}", id);
        verificarSeTarefaExiste(id);
        repository.deleteById(id);
        
    }

    @PutMapping("{id}")
    public Tarefa update(@PathVariable Long id, @RequestBody Tarefa tarefa){
        log.info("Atualiza tarefa {} para {}", id, tarefa);

        verificarSeTarefaExiste(id);
        tarefa.setId(id);
        return repository.save(tarefa);
    }

    private void verificarSeTarefaExiste(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "Não existe tarefa com o id informado"));


                        
                        
                        
    }

    
}
