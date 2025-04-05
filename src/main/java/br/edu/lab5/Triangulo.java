package br.edu.lab5;

public class Triangulo {
    private Triangulo() {
    }
    

    public static String tipoTriangulo(int x, int y, int z) {
        
        if (x <= 0 || y <= 0 || z <= 0) {
            throw new IllegalArgumentException("Os lados devem ter valores maiores que zero.");
        }
        
        if ((x + y) <= z || (x + z) <= y || (y + z) <= x) {
            throw new IllegalArgumentException("A soma de dois lados deve ser maior que o terceiro lado.");
        }
        
        if (x == y && y == z) {
            return "Equilátero";
        }

        if (x == y || x == z || y == z) {
            return "Isósceles";
        }
    
        return "Escaleno";
    }
}
