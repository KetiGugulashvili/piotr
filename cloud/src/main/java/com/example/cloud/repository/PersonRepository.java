package com.example.cloud.repository;

import com.example.cloud.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {
    private final List<Person> persons = new ArrayList<>();

    public Optional<Person> findById(int id) {
        return persons.stream().filter(person -> person.getId() == id).findFirst();
    }

    public List<Person> findAll() {
        return new ArrayList<>(persons);
    }

    public void delete(int id) {
        persons.removeIf(person -> person.getId() == id);
    }

    public Person add(Person person) {
        persons.add(person);
        return person;
    }

    public Person update(Person person) {
        delete(person.getId());
        add(person);
        return person;
    }
}
