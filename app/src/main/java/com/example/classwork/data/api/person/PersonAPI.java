package com.example.classwork.data.api.person;

import com.example.classwork.domain.Person;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PersonAPI {
    @GET("/person/{id}")
    Call<Person> getPerson(@Path("id") long id);
}
