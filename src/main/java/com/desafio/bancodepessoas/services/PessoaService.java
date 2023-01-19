package com.desafio.bancodepessoas.services;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.desafio.bancodepessoas.entities.PessoaModel;
import com.desafio.bancodepessoas.repositories.PessoaRepository;

@Service
public class PessoaService {

	final PessoaRepository pessoaRepository;
	
	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	@Transactional
    public PessoaModel save(PessoaModel pessoa) {
        return pessoaRepository.save(pessoa);
    }
	
	public List<PessoaModel> findAll() {
        return pessoaRepository.findAll();
    }
	
	public Optional<PessoaModel> findById(Integer id) {
		return pessoaRepository.findById(id);
	}
	
	@Transactional
	public void delete(PessoaModel pessoa) {
		pessoaRepository.delete(pessoa);
	}
	
}
