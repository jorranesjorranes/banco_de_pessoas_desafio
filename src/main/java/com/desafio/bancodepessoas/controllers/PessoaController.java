package com.desafio.bancodepessoas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.bancodepessoas.entities.PessoaModel;
import com.desafio.bancodepessoas.services.PessoaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api-pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<PessoaModel>> listarTodos() {
    	return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll());
    }
    
    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid PessoaModel pessoa) {  	
    	return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoa)); 		
    }    	      
    
    @PutMapping(value = "/{id}")
	public ResponseEntity<PessoaModel> update(@PathVariable Integer id, @RequestBody PessoaModel obj) {
		obj = pessoaService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id) {
    	Optional<PessoaModel> pessoaOptional = pessoaService.findById(id);
    	if (!pessoaOptional.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada.");
    	}
    	
		pessoaService.delete(pessoaOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Pessoa deletada com sucesso!");
	}
	
}