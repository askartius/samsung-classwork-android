package com.example.classwork.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PersonDBOpenHelper extends SQLiteOpenHelper {
    public PersonDBOpenHelper(@Nullable Context context) {
        super(context, PersonReaderContract.DATABASE_NAME, null, PersonReaderContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " +
                PersonReaderContract.PersonEntry.TABLE_NAME + " (" +
                PersonReaderContract.PersonEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PersonReaderContract.PersonEntry.COLUMN_NAME + " TEXT, " +
                PersonReaderContract.PersonEntry.COLUMN_AGE + " INTEGER" + ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PersonReaderContract.PersonEntry.TABLE_NAME + ";");
        onCreate(db);
    }
}
