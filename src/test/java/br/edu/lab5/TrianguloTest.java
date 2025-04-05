package br.edu.lab5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TrianguloTest {

    @Test
    public void testTrianguloEscalenoValido() {
        assertEquals("Escaleno", Triangulo.tipoTriangulo(3, 4, 5));
    }

    @ParameterizedTest
    @CsvSource({
        "3,3,4",
        "3,4,3",
        "4,3,3"
    })
    public void testTrianguloIsosceles(int x, int y, int z) {
        assertEquals("Isósceles", Triangulo.tipoTriangulo(x, y, z));
    }

    @Test
    public void testTrianguloEquilateroValido() {
        assertEquals("Equilátero", Triangulo.tipoTriangulo(3, 3, 3));
    }

    @ParameterizedTest
    @CsvSource({
        "0,3,4",
        "3,0,4",
        "3,4,0",
        "0,0,0"
    })
    public void testLadoZero(int x, int y, int z) {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            Triangulo.tipoTriangulo(x, y, z);
        });
        assertEquals("Os lados devem ter valores maiores que zero.", ex.getMessage());
    }

    @Test
    public void testLadoNegativo() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            Triangulo.tipoTriangulo(-1, 3, 4);
        });
        assertEquals("Os lados devem ter valores maiores que zero.", ex.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "1,2,3",
        "1,3,2",
        "2,1,3",
        "2,3,1",
        "3,1,2",
        "3,2,1"
    })
    public void testSomaIgualAoTerceiro(int x, int y, int z) {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            Triangulo.tipoTriangulo(x, y, z);
        });
        assertEquals("A soma de dois lados deve ser maior que o terceiro lado.", ex.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "2,2,5",
        "2,5,2",
        "5,2,2"
    })
    public void testSomaMenorQueOTerceiro(int x, int y, int z) {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            Triangulo.tipoTriangulo(x, y, z);
        });
        assertEquals("A soma de dois lados deve ser maior que o terceiro lado.", ex.getMessage());
    }
    @Test
public void testConstrutorPrivado() throws Exception {
    var constructor = Triangulo.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    constructor.newInstance(); 
}

}
