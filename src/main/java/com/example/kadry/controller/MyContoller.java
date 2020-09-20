package com.example.kadry.controller;

import com.example.kadry.model.Person;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyContoller {

    //@RequestMapping(value = "/hello/{imie}", method = RequestMethod.GET)   // Mapowanie głównego endpointa "/" do metody welcome
    @GetMapping("/hello/{imie}")  // skrócona wersja
    public String welcome(@PathVariable String imie,
                          @RequestParam(defaultValue = " jakiś piękny dzień") String dzientygodnia) {
        return "Witaj "+imie+" w "+dzientygodnia;
    }

    @GetMapping("persons")
    public Person getPersons() {
        return new Person("Jan","Kowalski", 34);
    }
}
