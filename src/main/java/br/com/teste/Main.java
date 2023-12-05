package br.com.teste;

import br.com.teste.controller.FuncionarioController;
import br.com.teste.modal.Funcionario;
import br.com.teste.view.FuncionarioView;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        FuncionarioController funcionarioController = new FuncionarioController();
        FuncionarioView funcionarioView = new FuncionarioView();

        funcionarioController.removerFuncionario(funcionarios, "João");

        // Imprime todos os funcionários
        funcionarioView.imprimirFuncionarios(funcionarios);

        // Aumenta o salario em 10%
        funcionarioController.aumentarSalario(funcionarios);


        // Imprime funcionário mais velho
        Optional<Funcionario> maisVelho = funcionarios.stream()
                .max(Comparator.comparingInt(funcionario -> LocalDate.now().getYear() - funcionario.getDataNascimento().getYear()));
        funcionarioView.imprimirFuncionarioMaisVelho(maisVelho);

        // Imprime funcionários em ordem alfabética
        funcionarioView.imprimirFuncionariosOrdemAlfabetica(funcionarios);

        // Imprime total dos salários
        funcionarioView.imprimirTotalSalarios(funcionarios);

        // Imprime salários em salários mínimos
        funcionarioView.imprimirSalariosMinimos(funcionarios);

        // Agrupar funcionários por função
        funcionarioView.agruparFuncionariosPorFuncao(funcionarios);

        // Imprime aniversariantes dos meses 10 e 12
        funcionarioView.imprimirAniversariantesMes(funcionarios, 10, 12);

    }

}