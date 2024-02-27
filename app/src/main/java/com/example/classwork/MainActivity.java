package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.classwork.dao.PersonDAO;
import com.example.classwork.dao.PersonDAOSQLite;
import com.example.classwork.domain.Person;

public class MainActivity extends AppCompatActivity {
    public static final String MAIN_ACTIVITY = "MainActivity";
    private PersonDAOSQLite personDAOSQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personDAOSQLite = new PersonDAOSQLite(this);

        Person person1 = new Person("Ivan", 10);
        personDAOSQLite.save(person1);
        personDAOSQLite.save(new Person("Petr", 18));
        personDAOSQLite.save(new Person("Nikolay", 16));

        Log.d(MAIN_ACTIVITY, personDAOSQLite.findAll().toString());

        try {
            Log.d(MAIN_ACTIVITY, "Removing " + personDAOSQLite.findById(person1.getId()));
        } catch (Exception e) {
            Log.e(MAIN_ACTIVITY, e.getMessage());
        }
        personDAOSQLite.deleteById(person1.getId());

        Log.d(MAIN_ACTIVITY, personDAOSQLite.findAll().toString());

    }
}