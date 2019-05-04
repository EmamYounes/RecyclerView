package com.example.smartec.recyclerview.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Smartec on 3/18/2018.
 */
public class InterViewDataBase extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "interview_db";

    public InterViewDataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBase.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DataBase.TABLE_NAME);
        // Create tables again
        onCreate(db);
    }

    public long insertDataBase( String question, String answer, String category) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(DataBase.COLUMN_Question, question);
        values.put(DataBase.COLUMN_Answer, answer);
        values.put(DataBase.COLUMN_Categ, category);
        // insert row
        long id = db.insert(DataBase.TABLE_NAME, null, values);
        // close db connection
        db.close();
        // return newly inserted row id
        return id;
    }

    public DataBase getData(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DataBase.TABLE_NAME,
                new String[]{DataBase.COLUMN_ID, DataBase.COLUMN_Question, DataBase.COLUMN_Answer,DataBase.COLUMN_Categ},
                DataBase.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        DataBase dataBase = new DataBase(
                cursor.getInt(cursor.getColumnIndex(DataBase.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(DataBase.COLUMN_Question)),
                cursor.getString(cursor.getColumnIndex(DataBase.COLUMN_Answer)),
                cursor.getString(cursor.getColumnIndex(DataBase.COLUMN_Categ)));

        // close the db connection
        cursor.close();

        return dataBase;
    }

    public List<DataBase> getAllData() {
        List<DataBase> dataBaseList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DataBase.TABLE_NAME + " ORDER BY " +
                DataBase.COLUMN_ID + " ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DataBase dataBase = new DataBase();
                dataBase.setId(cursor.getInt(cursor.getColumnIndex(DataBase.COLUMN_ID)));
                dataBase.setQuestion(cursor.getString(cursor.getColumnIndex(DataBase.COLUMN_Question)));
                dataBase.setAnswer(cursor.getString(cursor.getColumnIndex(DataBase.COLUMN_Answer)));
                dataBase.setCategory(cursor.getString(cursor.getColumnIndex(DataBase.COLUMN_Categ)));
                dataBaseList.add(dataBase);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return dataBaseList;
    }

    public List<DataBase> getAllData(String catg) {
        List<DataBase> dataBaseList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DataBase.TABLE_NAME + " WHERE " +
                DataBase.COLUMN_Categ + " =?";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{catg});
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DataBase dataBase = new DataBase();
                dataBase.setId(cursor.getInt(cursor.getColumnIndex(DataBase.COLUMN_ID)));
                dataBase.setQuestion(cursor.getString(cursor.getColumnIndex(DataBase.COLUMN_Question)));
                dataBase.setAnswer(cursor.getString(cursor.getColumnIndex(DataBase.COLUMN_Answer)));
                dataBase.setCategory(cursor.getString(cursor.getColumnIndex(DataBase.COLUMN_Categ)));
                dataBaseList.add(dataBase);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return dataBaseList;
    }


    public int getDataCount() {
        String countQuery = "SELECT  * FROM " + DataBase.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    public int getDataCount(String catg) {
        String countQuery = "SELECT  * FROM " + DataBase.TABLE_NAME + " WHERE " +
                DataBase.COLUMN_Categ + " =?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, new String[]{catg});
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }


    public int updateData(DataBase dataBase) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DataBase.COLUMN_Question, dataBase.getQuestion());
        values.put(DataBase.COLUMN_Answer, dataBase.getAnswer());
        values.put(DataBase.COLUMN_Categ, dataBase.getQuestion());

        // updating row
        return db.update(DataBase.TABLE_NAME, values, DataBase.COLUMN_ID + " = ?",
                new String[]{String.valueOf(dataBase.getId())});
    }

    public void deleteData(DataBase dataBase) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DataBase.TABLE_NAME, DataBase.COLUMN_ID + " = ?",
                new String[]{String.valueOf(dataBase.getId())});
        db.close();
    }

    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ DataBase.TABLE_NAME);

        db.close();
    }

    public String getSearchResult(String question){

        String selectQuery = "SELECT  * FROM " + DataBase.TABLE_NAME + " WHERE " +
                DataBase.COLUMN_Question + " =?";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{question});
        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor.getString(cursor.getColumnIndex(DataBase.COLUMN_Answer));
    }



}