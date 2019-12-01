package com.e.myapplication.ui;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    private static int VERSION = 1;
    private static final String DATABASE_NAME = "MyBooks";

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String script = "Create table books (NameOfBook Text primary key, Content Text, NumberOfChapter int, ChapterPause int, icon Text)";
        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addBooks(Truyen book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NameOfBook", book.getTentruyen());
        values.put("Content", book.getDatatruyen());
        values.put("NumberOfChapter", book.getSochuong());
        values.put("ChapterPause",0);
        values.put("icon", book.getIcon());
        db.insert("books", null, values);
    }


    public ArrayList<Truyen> getAllBook() {
        ArrayList<Truyen> books = new ArrayList<Truyen>();
        String script = " Select * from books";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(script, null);
        while (cursor.moveToNext()) {
            Truyen book = new Truyen();
            book.setTentruyen(cursor.getString(0));
            book.setDatatruyen(cursor.getString(1));
            books.add(book);
        }
        return books;
    }


}



