package br.com.fiap.daybyday.controller;

import static org.springframework.http.HttpStatus.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.daybyday.model.Categoria;
import br.com.fiap.daybyday.repository.CategoriaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository repository;

    @GetMapping
    public List<Categoria> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Categoria create(@RequestBody @Valid Categoria categoria){
        return repository.save(categoria);
    }
    
}
