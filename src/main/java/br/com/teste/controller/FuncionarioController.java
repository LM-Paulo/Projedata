package br.com.teste.controller;

import br.com.teste.modal.Funcionario;

import java.math.BigDecimal;
import java.util.List;

public class FuncionarioController {

    public void removerFuncionario(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));
    }

    public void aumentarSalario(List<Funcionario> funcionarios) {
        funcionarios.forEach(funcionario -> {
            BigDecimal novoSalario = funcionario.getSalario().multiply(new BigDecimal("1.1"));
            funcionario.setSalario(novoSalario);
        });
    }

    // Outros métodos de operações com funcionários podem ser adicionados aqui
}
