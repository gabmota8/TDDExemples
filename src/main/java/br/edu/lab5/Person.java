package br.edu.lab5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    private int age;
    private List<Email> emails = new ArrayList<>();

    public List<String> isValidToInclude(Person p) {
        List<String> errors = new ArrayList<>();

        
        if (p.getName() == null || p.getName().isBlank()) {
            errors.add("Nome não pode ser vazio");
        } else {
            String[] parts = p.getName().trim().split("\\s+");
            if (parts.length < 2) {
                errors.add("Nome deve conter pelo menos duas partes");
            }
            if (!p.getName().matches("^[A-Za-zÀ-ú\\s]+$")) {
                errors.add("Nome deve conter apenas letras");
            }
        }

        
        if (p.getAge() < 1 || p.getAge() > 200) {
            errors.add("Idade deve estar entre 1 e 200");
        }

        
        if (p.getEmails() == null || p.getEmails().isEmpty()) {
            errors.add("Pessoa deve ter pelo menos um email");
        } else {
            for (Email email : p.getEmails()) {
                String emailName = email.getName();
                if (emailName == null || !emailName.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
                    errors.add("Formato de email inválido: " + emailName);
                }
            }
        }

        return errors;
    }
}
