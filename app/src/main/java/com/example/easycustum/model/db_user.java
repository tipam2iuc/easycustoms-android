package com.example.easycustum.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class db_user extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME="register.db";
    public static  final int DATABASE_VERSION = 1;


    public static  final String TABLE_NAME="user";

    public static  final String KEY_ID ="id";
    public static  final String KEY_USERNAME ="username";
    public static  final String KEY_PASSWORD ="password";

    public db_user(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String strSQL = "create table" + TABLE_NAME +"("
                        + " id integer primary key autoincrement,"
                        + " username text not null,"
                        + " password text not null"
                        + ")";
        String strSQLUser = "CREATE TABLE "
                + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_USERNAME   + "    TEXT NOT NULL,"
                + KEY_PASSWORD   + "    TEXT NOT NULL"
                + ")";
        db.execSQL(strSQLUser);

        Log.i("DATABASE ", "table create ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public long insertUser(String user,String password){

        ContentValues values = new ContentValues();
        values.put("username", user);
        values.put("password", password);
        SQLiteDatabase db = this.getWritableDatabase();
        long res = db.insert("T_Users", null, values);
        db.close();
        Log.i("DATABASE", "insertUser invoke");
        return res;
    }
    public long addUser (String user,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", user);
        contentValues.put ("password", password);
        long res =db.insert (TABLE_NAME, null, contentValues);
        db.close();
        return res;
    }
//    public boolean checkUser (String username, String password){
//        String[] columns = {KEY_ID};
//        SQLiteDatabase db = getReadableDatabase();
//        String selection = KEY_USERNAME +"m?" + "and" + KEY_PASSWORD +"m?";
//        String[] selecionArgs = {username, password};
//        Cursor cursor = db.query(TABLE_NAME,columns,selection,selecionArgs,null,null,null );
//        int count = cursor.getCount();
//        cursor.close();
//        db.close();
//        if (count>0)
//            return true;
//        else
//            return false;
//    }
}
