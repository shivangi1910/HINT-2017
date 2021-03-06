package com.example.shivangi.reunion;

/**
 * Created by shivangi on 23/3/17.
 */


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperSetting extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "SETTING";

    // Table columns
    public static final String _ID = "_id";
    public static final String SUBJECT = "value";
    public static final String VOTES = "votes";


    // Database Information
    static final String DB_NAME = "SHIVANGI.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SUBJECT + " TEXT NOT NULL " + VOTES + " INTEGER);";

    public DBHelperSetting(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}