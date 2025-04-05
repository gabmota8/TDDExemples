package br.edu.lab5;

public class CalculadoraSalario {

    public Double calcular(Funcionario funcionario) {
        Double salarioBase = funcionario.getSalarioBase();
        if (funcionario.getCargo() == null)
            return 0.0;

        CargoEnum cargo = funcionario.getCargo();
        return salarioBase * (salarioBase >= cargo.getLimite() ? cargo.getTaxaSuperior() : cargo.getTaxaInferior());
    }
}
