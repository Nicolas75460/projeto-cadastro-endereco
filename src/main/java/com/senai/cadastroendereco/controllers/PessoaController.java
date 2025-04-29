package com.senai.cadastroendereco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.cadastroendereco.entities.Pessoa;
import com.senai.cadastroendereco.services.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    // Criar uma nova pessoa
    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        return pessoaService.salvar(pessoa);
    }

    // Buscar uma pessoa pelo ID
    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable Long id) {
        return pessoaService.buscarPorId(id);
    }

    // Excluir uma pessoaO
    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        pessoaService.deletarPorId(id);
    }

    // Listar todas as pessoas
    @GetMapping
    public List<Pessoa> listarTodas() {
        return pessoaService.listarTodas();
    }

    // Buscar pessoa por email
    @GetMapping("/email/{email}")
    public Pessoa buscarPorEmail(@PathVariable String email) {
        return pessoaService.buscarPorEmail(email);
    }

}