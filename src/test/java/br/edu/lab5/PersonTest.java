package br.edu.lab5;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private List<String> validate(Person p) {
        return p.isValidToInclude(p);
    }

    @Test
    void shouldReturnNoErrorsForValidPerson() {
        Person person = new Person(1, "João Silva", 30, List.of(new Email(1, "joao.silva@email.com")));
        List<String> errors = validate(person);
        assertTrue(errors.isEmpty(), "Esperava-se nenhuma mensagem de erro.");
    }

    @Test
    void shouldReturnErrorForEmptyName() {
        Person p = new Person(1, "", 25, List.of(new Email(1, "teste@exemplo.com")));
        List<String> errors = validate(p);
        assertTrue(errors.contains("Nome não pode ser vazio"));
    }

    @Test
    void shouldReturnErrorForSingleWordName() {
        Person p = new Person(1, "Joao", 25, List.of(new Email(1, "teste@exemplo.com")));
        List<String> errors = validate(p);
        assertTrue(errors.contains("Nome deve conter pelo menos duas partes"));
    }

    @Test
    void shouldReturnErrorForNameWithInvalidCharacters() {
        Person p = new Person(1, "Joao123 Silva!", 25, List.of(new Email(1, "teste@exemplo.com")));
        List<String> errors = validate(p);
        assertTrue(errors.contains("Nome deve conter apenas letras"));
    }

    @Test
    void shouldReturnErrorForAgeLessThanOne() {
        Person p = new Person(1, "Joao Silva", 0, List.of(new Email(1, "teste@exemplo.com")));
        List<String> errors = validate(p);
        assertTrue(errors.contains("Idade deve estar entre 1 e 200"));
    }

    @Test
    void shouldReturnErrorForAgeGreaterThan200() {
        Person p = new Person(1, "Joao Silva", 201, List.of(new Email(1, "teste@exemplo.com")));
        List<String> errors = validate(p);
        assertTrue(errors.contains("Idade deve estar entre 1 e 200"));
    }

    @Test
    void shouldReturnErrorForNoEmails() {
        Person p = new Person(1, "Joao Silva", 30, new ArrayList<>());
        List<String> errors = validate(p);
        assertTrue(errors.contains("Pessoa deve ter pelo menos um email"));
    }

    @Test
    void shouldReturnErrorForInvalidEmailFormat_MissingAt() {
        Person p = new Person(1, "Joao Silva", 30, List.of(new Email(1, "email.sem.arroba.com")));
        List<String> errors = validate(p);
        assertTrue(errors.stream().anyMatch(e -> e.contains("Formato de email inválido")));
    }

    @Test
    void shouldReturnErrorForInvalidEmailFormat_MissingDomain() {
        Person p = new Person(1, "Joao Silva", 30, List.of(new Email(1, "teste@.com")));
        List<String> errors = validate(p);
        assertTrue(errors.stream().anyMatch(e -> e.contains("Formato de email inválido")));
    }

    @Test
    void shouldReturnMultipleErrorsAtOnce() {
        Person p = new Person(1, "Ana", -5, new ArrayList<>());
        List<String> errors = validate(p);
        assertEquals(3, errors.size());
        assertTrue(errors.contains("Nome deve conter pelo menos duas partes"));
        assertTrue(errors.contains("Idade deve estar entre 1 e 200"));
        assertTrue(errors.contains("Pessoa deve ter pelo menos um email"));
    }
    @Test
    void shouldReturnErrorForNullName() {
        Person p = new Person(1, null, 30, List.of(new Email(1, "teste@exemplo.com")));
        List<String> errors = validate(p);

        assertTrue(errors.contains("Nome não pode ser vazio"));
    }

    @Test
    void shouldHandleNameWithExtraSpaces() {
        Person p = new Person(1, "  Joao    Silva  ", 30, List.of(new Email(1, "teste@exemplo.com")));
        List<String> errors = validate(p);

        assertTrue(errors.isEmpty(), "Nome com espaços extras deve ser considerado válido");
    }

    @Test
    void shouldReturnErrorForNullEmailList() {
        Person p = new Person(1, "Joao Silva", 30, null);
        List<String> errors = validate(p);

        assertTrue(errors.contains("Pessoa deve ter pelo menos um email"));
    }

    @Test
    void shouldReturnErrorForEmailWithNullName() {
        Person p = new Person(1, "Joao Silva", 30, List.of(new Email(1, null)));
        List<String> errors = validate(p);

        assertTrue(errors.stream().anyMatch(e -> e.contains("Formato de email inválido")));
    }

}
