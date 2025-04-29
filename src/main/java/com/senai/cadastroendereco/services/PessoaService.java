package com.senai.cadastroendereco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.cadastroendereco.entities.Pessoa;
import com.senai.cadastroendereco.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	// Salvar uma nova pessoa
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public List<Pessoa> listarTodas()  {
		return pessoaRepository.findAll();
	}
	
	public Pessoa buscarPorId(Long id) {
		return pessoaRepository.findById(id).orElse(null);
	}
	
	public void deletarPorId(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	public Pessoa buscarPorEmail(String email) {
		return pessoaRepository.findByEmail(email);
	}
	
	// Verificar email e senha
	public Pessoa autenticarPessoa(String email, String senha) {
		// Verifica existência do email
		Pessoa pessoa = pessoaRepository.findByEmail(email);
		
		if (pessoa != null && pessoa.getSenha().equals(senha)) {
			return pessoa;
		} else {
			return null;
		}
	}
}
