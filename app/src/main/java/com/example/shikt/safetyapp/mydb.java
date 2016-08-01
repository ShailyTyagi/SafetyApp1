package com.example.shikt.safetyapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shikt on 26-07-2016.
 */
public class mydb extends SQLiteOpenHelper {
private static final int DTABASE_VERSION=1;
    private static final String DATABASE_NAME="mydb.db";
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_FNAME="fname";
    public static final String COLUMN_LNAME="lname";


    public mydb(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       // String query={"CREATE TABLE"}

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
