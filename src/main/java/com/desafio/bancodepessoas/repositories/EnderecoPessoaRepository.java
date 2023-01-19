package com.desafio.bancodepessoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.bancodepessoas.entities.EnderecoPessoaModel;

@Repository
public interface EnderecoPessoaRepository extends JpaRepository<EnderecoPessoaModel, Integer> {

}
