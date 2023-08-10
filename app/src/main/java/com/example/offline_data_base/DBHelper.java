package com.example.offline_data_base;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper
{

    public DBHelper(@Nullable Context context) {
        super(context, "ContactBook", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query = "create table Contact(ID integer primary key autoincrement,NAME text,NUMBER text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}


    public void adddata(String name, String number)
    {
        String query = "insert into Contact(NAME,NUMBER) values('"+name+"','"+number+"')";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
    }

    public Cursor displaydata() {
        String query = "select * from Contact";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }

    public void updatedata(Editable id, String name, String number) {
        String query = "update Contact set NAME='"+name+"',NUMBER='"+number+"' where ID="+id+"";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
    }

    public void deletedata(Editable id) {
        String query="delete from Contact where ID="+id+"";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query);
    }
}
