package com.desafio.bancodepessoas.entities;

import java.util.Objects;

import com.desafio.bancodepessoas.enums.EnderecoPessoaEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ENDERECO_PESSOA_MODEL")
public class EnderecoPessoaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String logradouro;
	private Integer cep;
	private Integer numero;
	private String cidade;
	private EnderecoPessoaEnum enderecoPessoaEnum;
	
	@ManyToOne
	private PessoaModel pessoaModel;

	

	public EnderecoPessoaModel(Integer id, String logradouro, Integer cep, Integer numero, String cidade,
			EnderecoPessoaEnum enderecoPessoaEnum, PessoaModel pessoaModel) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
		this.enderecoPessoaEnum = enderecoPessoaEnum;
		this.pessoaModel = pessoaModel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public EnderecoPessoaEnum getEnderecoPessoaEnum() {
		return enderecoPessoaEnum;
	}

	public void setEnderecoPessoaEnum(EnderecoPessoaEnum enderecoPessoaEnum) {
		this.enderecoPessoaEnum = enderecoPessoaEnum;
	}

	public PessoaModel getPessoaModel() {
		return pessoaModel;
	}

	public void setPessoaModel(PessoaModel pessoaModel) {
		this.pessoaModel = pessoaModel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoPessoaModel other = (EnderecoPessoaModel) obj;
		return Objects.equals(id, other.id);
	}
	
}
