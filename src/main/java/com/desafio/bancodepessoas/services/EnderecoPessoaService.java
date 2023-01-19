package com.desafio.bancodepessoas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.desafio.bancodepessoas.entities.EnderecoPessoaModel;
import com.desafio.bancodepessoas.repositories.EnderecoPessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class EnderecoPessoaService {

	final EnderecoPessoaRepository enderecoPessoaRepository;
	
	public EnderecoPessoaService(EnderecoPessoaRepository enderecoPessoaRepository) {
		this.enderecoPessoaRepository = enderecoPessoaRepository;
	}
	
	@Transactional
    public EnderecoPessoaModel save(EnderecoPessoaModel enderecoPessoa) {
        return enderecoPessoaRepository.save(enderecoPessoa);
    }
	
	public List<EnderecoPessoaModel> findAll() {
        return enderecoPessoaRepository.findAll();
    }
	
	public Optional<EnderecoPessoaModel> findById(Integer id) {
		return enderecoPessoaRepository.findById(id);
	}
	
	@Transactional
	public void delete(EnderecoPessoaModel enderecoPessoa) {
		enderecoPessoaRepository.delete(enderecoPessoa);
	}
	
}
