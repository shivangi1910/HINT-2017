package com.example.shivangi.reunion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.shivangi.reunion.DatabaseHelper.TABLE_2;

/**
 * Created by shivangi on 24/3/17.
 */

public class GroupClasses extends SQLiteOpenHelper {

    public static final String TABLE1_NAME = "GROUP";
    public static final String TABLE2_NAME = "USER_N_GROUP";
    //Database Information
    static final String DB_NAME = "SHIVANGI.DB";
    public static final String _ID = "_id";
    public static final String NAME = "subject";
    //public static final String VOTES = "votes";

    public static final String _GID = "Groupid";
    public static final String _UID = "Userid";


    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE1_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT NOT NULL;";

    private static final String CREATE_TABLE2 = "create table " + TABLE2_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + _GID + " INTEGER " + _UID + " INTEGER;";

    public GroupClasses(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);

        onCreate(db);
    }
}

