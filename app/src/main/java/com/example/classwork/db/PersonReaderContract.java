package com.example.classwork.db;

public class PersonReaderContract {
    private PersonReaderContract() {
    }

    public static final String DATABASE_NAME = "person.db";
    public static final int DATABASE_VERSION = 1;

    public static class PersonEntry {
        public static final String TABLE_NAME = "person";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AGE = "age";
    }
}
