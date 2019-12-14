package com.e.myapplication.ui;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;
    protected DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }
    public static DatabaseAccess getInstance(Context context){
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }
    public void open(){
        this.database = openHelper.getWritableDatabase();
    }

    public void close(){
        if(database!= null){
            this.database.close();
        }
    }

    public List<String> getName(){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("Select * from truyen",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getData(){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("Select * from truyen",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(2));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getDataEng(){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("Select * from truyen",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(4));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getNameEng(){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("Select * from truyen",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(3));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
