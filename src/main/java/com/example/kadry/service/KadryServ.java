package com.example.kadry.service;

import com.example.kadry.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KadryServ {

    private List<Person> persons;

    public KadryServ() {
        persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }

}
