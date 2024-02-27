package com.example.classwork.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.classwork.db.PersonDBOpenHelper;
import com.example.classwork.db.PersonReaderContract;
import com.example.classwork.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOSQLite implements PersonDAO {
    private final PersonDBOpenHelper openHelper;

    public PersonDAOSQLite(Context context) {
        this.openHelper = new PersonDBOpenHelper(context);
    }

    @Override
    public Person save(Person person) {
        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(PersonReaderContract.PersonEntry.COLUMN_NAME, person.getName());
        contentValues.put(PersonReaderContract.PersonEntry.COLUMN_AGE, person.getAge());

        long insert = writableDatabase.insert(
                PersonReaderContract.PersonEntry.TABLE_NAME,
                null,
                contentValues
        );

        person.setId(insert);
        writableDatabase.close();
        return person;
    }

    @Override
    public List<Person> findAll() {
        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();

        Cursor cursor = readableDatabase.query(
                PersonReaderContract.PersonEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        List<Person> personList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            int columnIndexId = cursor.getColumnIndex(PersonReaderContract.PersonEntry.COLUMN_ID);
            int columnIndexName = cursor.getColumnIndex(PersonReaderContract.PersonEntry.COLUMN_NAME);
            int columnIndexAge = cursor.getColumnIndex(PersonReaderContract.PersonEntry.COLUMN_AGE);

            do {
                Person person = new Person(
                        cursor.getLong(columnIndexId),
                        cursor.getString(columnIndexName),
                        cursor.getInt(columnIndexAge)
                );

                personList.add(person);
            } while (cursor.moveToNext());
        }

        cursor.close();
        readableDatabase.close();
        return personList;
    }

    @Override
    public Person findById(long id) throws Exception {
        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();

        Cursor cursor = readableDatabase.query(
                PersonReaderContract.PersonEntry.TABLE_NAME,
                null,
                PersonReaderContract.PersonEntry.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null
        );

        Person person;

        if (cursor.moveToFirst()) {
            int columnIndexId = cursor.getColumnIndex(PersonReaderContract.PersonEntry.COLUMN_ID);
            int columnIndexName = cursor.getColumnIndex(PersonReaderContract.PersonEntry.COLUMN_NAME);
            int columnIndexAge = cursor.getColumnIndex(PersonReaderContract.PersonEntry.COLUMN_AGE);

            person = new Person(
                    cursor.getLong(columnIndexId),
                    cursor.getString(columnIndexName),
                    cursor.getInt(columnIndexAge)
            );
        } else throw new Exception("Person not found");

        cursor.close();
        readableDatabase.close();
        return person;
    }

    @Override
    public int update(long id, Person person) {
        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(PersonReaderContract.PersonEntry.COLUMN_NAME, person.getName());
        contentValues.put(PersonReaderContract.PersonEntry.COLUMN_AGE, person.getAge());

        int update = writableDatabase.update(PersonReaderContract.PersonEntry.TABLE_NAME,
                contentValues,
                PersonReaderContract.PersonEntry.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)}
        );

        writableDatabase.close();
        return update;
    }

    @Override
    public int deleteById(long id) {
        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();

        int delete = writableDatabase.delete(
                PersonReaderContract.PersonEntry.TABLE_NAME,
                PersonReaderContract.PersonEntry.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)}
        );

        writableDatabase.close();
        return delete;
    }
}
