package com.example.classwork.data.repository;

import com.example.classwork.data.api.person.PersonAPIService;
import com.example.classwork.domain.Person;

import retrofit2.Call;

public class PersonRepository {
    public static Call<Person> getPerson(long id) {
        return PersonAPIService.getInstance().getPerson(id);
    }
}
