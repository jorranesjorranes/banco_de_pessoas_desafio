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

import com.desafio.bancodepessoas.entities.EnderecoPessoaModel;
import com.desafio.bancodepessoas.services.EnderecoPessoaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api-endereco-pessoa")
public class EnderecoPessoaController {

    private final EnderecoPessoaService enderecoPessoaService;

    public EnderecoPessoaController(EnderecoPessoaService enderecoPessoaService) {
        this.enderecoPessoaService = enderecoPessoaService;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoPessoaModel>> listarTodos() {
    	return ResponseEntity.status(HttpStatus.OK).body(enderecoPessoaService.findAll());
    }
    
    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid EnderecoPessoaModel enderecoPessoa) { 	
    	return ResponseEntity.status(HttpStatus.CREATED).body(enderecoPessoaService.save(enderecoPessoa)); 		
    }    	      
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEnderecoPessoa(@PathVariable(value = "id") Integer id,
                                                    @RequestBody @Valid EnderecoPessoaModel enderecoPessoa){
        Optional<EnderecoPessoaModel> enderecoPessoaOptional = enderecoPessoaService.findById(id);
        if (!enderecoPessoaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço para essa pessoa não encontrado.");
        }
        enderecoPessoa = enderecoPessoaOptional.get();
        enderecoPessoa.setId(enderecoPessoaOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(enderecoPessoaService.save(enderecoPessoa));
    }
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id) {
    	Optional<EnderecoPessoaModel> enderecoPessoaOptional = enderecoPessoaService.findById(id);
    	if (!enderecoPessoaOptional.isPresent()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço para essa pessoa não encontrado.");
    	}
    	
		enderecoPessoaService.delete(enderecoPessoaOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Endereço para essa pessoa deletado com sucesso!");
	}
	
}