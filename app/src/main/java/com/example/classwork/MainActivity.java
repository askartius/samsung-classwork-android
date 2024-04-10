package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.classwork.data.repository.PersonRepository;
import com.example.classwork.domain.Person;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PersonRepository.getPerson(0).enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                Log.d("Person", response.body().toString());
            }

            @Override
            public void onFailure(Call<Person> call, Throwable throwable) {
                Log.d("Person", throwable.getMessage());
            }
        });
    }
}