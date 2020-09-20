package com.example.kadry.controller;

import com.example.kadry.model.Person;
import com.example.kadry.service.KadryServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyContoller {

    @Autowired
    KadryServ kadry;

    //@RequestMapping(value = "/hello/{imie}", method = RequestMethod.GET)   // Mapowanie głównego endpointa "/" do metody welcome
    @GetMapping("/hello/{imie}")  // skrócona wersja
    public String welcome(@PathVariable String imie,
                          @RequestParam(defaultValue = " jakiś piękny dzień") String dzientygodnia) {
        return "Witaj "+imie+" w "+dzientygodnia;
    }

    @GetMapping("persons")
    public List<Person> getPersons(@RequestParam(defaultValue = "all") String imie) {

        List<Person> filteredPersons = new ArrayList<>();

        if (imie.equals("all"))
            return kadry.getPersons();
        else {
            for(Person person : kadry.getPersons()) {
                if (person.getImie().equals(imie)) filteredPersons.add(person);
            }
            return filteredPersons;
        }
    }

    @PostMapping("persons")
    public String addPerson(@RequestBody Person person) {
        kadry.addPerson(person);
        return "Osoba dodana do listy";
    }

    @DeleteMapping("persons")
    public String deletePerson(@RequestParam String pesel) {

        Person tempPerson = null;
        for (Person person : kadry.getPersons()) {
            if (person.getPesel().equals(pesel)) {
                tempPerson = person;

            }
            if (tempPerson != null) {
                kadry.getPersons().remove(tempPerson);
                return "Osoba o peselu "+pesel+" usunięta z listy";
            }

        }

        return "Osoby o peselu "+pesel+" nie ma na liście";


    }


}
