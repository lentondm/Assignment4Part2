package edu.vcu.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_FIRST = "first";
    private static final String COLUMN_SECOND = "second";
    private static final String TABLE_CREATE = "create table contacts (first word text not null , second word text not null)";
    SQLiteDatabase db;

    public DatabaseHelper(Context c){
        super(c , DATABASE_NAME , null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS contacts";
        db.execSQL(query);
        this.onCreate(db);
    }


    public void insertContact(Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST, c.getFirst());
        values.put(COLUMN_SECOND, c.getSecond());
        db.insert(TABLE_NAME, null, values);
    }

    public String findSynonym(String s){
        db = this.getReadableDatabase();
        String query = "select first , second from contacts";
        Cursor cursor = db.rawQuery(query, null);

        String a,b;
        b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                if (a.equals(s)){
                    b = cursor.getString(1);
                    break;
                }

            }
            while(cursor.moveToNext());
        }
        return b;
    }


}
