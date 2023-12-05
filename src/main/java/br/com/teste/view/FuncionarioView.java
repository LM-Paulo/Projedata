package br.com.teste.view;

import br.com.teste.modal.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FuncionarioView {

    public void imprimirFuncionarios(List<Funcionario> funcionarios) {
        funcionarios.forEach(funcionario -> {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Data de Nascimento: " + funcionario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("Salário: " + funcionario.getSalario().toString().replace(".", ","));
            System.out.println("Função: " + funcionario.getFuncao());
            System.out.println("--------------");
        });
    }

    public void imprimirFuncionarioMaisVelho(Optional<Funcionario> maisVelho) {
        maisVelho.ifPresent(funcionario -> {
            int idade = LocalDate.now().getYear() - funcionario.getDataNascimento().getYear();
            System.out.println("Funcionário mais velho:");
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Idade: " + idade + " anos");
        });
    }

    public void imprimirFuncionariosOrdemAlfabetica(List<Funcionario> funcionarios) {
        System.out.println("--------------Ordem alfabetica");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(funcionario -> System.out.println(funcionario.getNome()));

    }

    public void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("------------------ ");
        System.out.println("Total dos salários: " + totalSalarios.toString().replace(".", ","));
    }

    public void imprimirSalariosMinimos(List<Funcionario> funcionarios) {
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        funcionarios.forEach(funcionario -> {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_DOWN);
            System.out.println(funcionario.getNome() + " ganha " + salariosMinimos + " salários mínimos");
        });
    }

    public void agruparFuncionariosPorFuncao(List<Funcionario> funcionarios) {
        funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao))
                .forEach((funcao, lista) -> {
                    System.out.println("------------------ ");
                    System.out.println("Funcionários na função " + funcao + ":");
                    lista.forEach(f -> System.out.println(f.getNome()));
                });
    }

    public void imprimirAniversariantesMes(List<Funcionario> funcionarios, int... meses) {
        funcionarios.stream()
                .filter(funcionario -> {
                    int mesNascimento = funcionario.getDataNascimento().getMonthValue();
                    for (int mes : meses) {
                        if (mes == mesNascimento) {
                            return true;
                        }
                    }
                    return false;
                })
                .forEach(funcionario -> {
                    System.out.println("Nome: " + funcionario.getNome());
                    System.out.println("Data de Nascimento: " + funcionario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    System.out.println("--------------");
                });
    }
}
