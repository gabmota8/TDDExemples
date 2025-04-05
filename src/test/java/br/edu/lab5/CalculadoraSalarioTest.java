package br.edu.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculadoraSalarioTest {

    @ParameterizedTest
    @MethodSource("provideInputAndExpectedValues")
    public void validarCalculoSalarioDesenvolvedor(String nome, String email, Double salarioBase, CargoEnum cargo, Double salarioExperado) {
        Funcionario funcionario = new Funcionario(nome, email, salarioBase, cargo);
        CalculadoraSalario cut = new CalculadoraSalario();
        Double salarioFinal = cut.calcular(funcionario);
        Assertions.assertEquals(salarioExperado, salarioFinal);
    }

    private static Stream<Arguments> provideInputAndExpectedValues() {
        return Stream.of(
                Arguments.of("Nome 1", "nome1@lp2.com", 3000.0, null, 0.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 1000.0, CargoEnum.DESENVOLVEDOR, 900.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 4000.0, CargoEnum.DESENVOLVEDOR, 3200.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 3000.0, CargoEnum.DESENVOLVEDOR, 2400.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 1000.0, CargoEnum.DBA, 850.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 2000.0, CargoEnum.DBA, 1500.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 3000.0, CargoEnum.DBA, 2250.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 1000.0, CargoEnum.TESTADOR, 850.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 2000.0, CargoEnum.TESTADOR, 1500.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 3000.0, CargoEnum.TESTADOR, 2250.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 1000.0, CargoEnum.GERENTE, 800.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 5000.0, CargoEnum.GERENTE, 3500.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 6000.0, CargoEnum.GERENTE, 4200.0)
        );
    }
}
