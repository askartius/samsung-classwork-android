package com.example.classwork.dao;

import com.example.classwork.domain.Person;

import java.util.List;

public interface PersonDAO {
    Person save(Person person);
    List<Person> findAll();
    Person findById(long id) throws Exception;
    int update(long id, Person person);
    int deleteById(long id);
}
