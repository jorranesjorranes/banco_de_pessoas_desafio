package com.desafio.bancodepessoas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.desafio.bancodepessoas.entities.EnderecoPessoaModel;
import com.desafio.bancodepessoas.entities.PessoaModel;
import com.desafio.bancodepessoas.repositories.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class PessoaService {

	final PessoaRepository pessoaRepository;

	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@Transactional
    public PessoaModel save(PessoaModel pessoa) {
		for (EnderecoPessoaModel endereco : pessoa.getEnderecos()) {
			endereco.setPessoa(pessoa);
		}
		return pessoaRepository.save(pessoa);
    }
	
	public List<PessoaModel> findAll() {
        return pessoaRepository.findAll();
    }
	
	public Optional<PessoaModel> findById(Integer id) {
		return pessoaRepository.findById(id);
	}
	
	public PessoaModel update(Integer id, PessoaModel obj) {
			PessoaModel entity = pessoaRepository.getReferenceById(id);
			updateData(entity, obj);
			return pessoaRepository.save(entity);
	}

	private void updateData(PessoaModel entity, PessoaModel obj) {
		if(entity.getNome() != null) {
			entity.setNome(obj.getNome());
		}
		if(entity.getDataDeNascimento() != null) {
		entity.setDataDeNascimento(obj.getDataDeNascimento());
		}
		if(!entity.getEnderecos().isEmpty()) {
			entity.setEnderecos(obj.getEnderecos());			
		}
	}
	
	@Transactional
	public void delete(PessoaModel pessoa) {
		pessoaRepository.delete(pessoa);
	}
	
}
