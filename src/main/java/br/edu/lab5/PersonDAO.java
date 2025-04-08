package br.edu.lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonDAO {
    private final List<Person> persons;
    
    public PersonDAO() {
        this.persons = new ArrayList<>();
    }
    
    public void save(Person p) {
        if (p == null) {
            throw new NullPointerException("Person cannot be null");
        }
        persons.add(p);
    }
    
    public List<Person> getPersons() {
        return Collections.unmodifiableList(persons);
    }
    
    public int getCount() {
        return persons.size();
    }
}