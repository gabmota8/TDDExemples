package br.edu.lab5;

import java.util.ArrayList;
import java.util.List;


public class PersonDAO {  
    private List<Person> persons;  

    public PersonDAO() {  
        this.persons = new ArrayList<>();  
    }  

    
    public void save(Person p) {  
        persons.add(p);  
    }
}