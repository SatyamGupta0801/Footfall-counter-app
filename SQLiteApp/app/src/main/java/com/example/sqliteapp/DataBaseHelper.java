package com.example.sqliteapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="footfall_count.db";
    public static final String TABLE_NAME="footfallcount_TABLE";
    public static final String PLACE_NAME="PLACE_NAME PRIMARY KEY";
    public static final String MAXIMUM_ALLOWED="MAXIMUM_ALLOWED int ";
    public static final String CURRENT_FOOTFALL=" CURRENT_FOOTFALL int ";
    public static final String database_column=" PLACE_NAME  MAXIMUM_ALLOWED  CURRENT_FOOTFALL \n";
    public DataBaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME , null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table "+TABLE_NAME+" ("+PLACE_NAME+","+MAXIMUM_ALLOWED+","+CURRENT_FOOTFALL+")");
        db.execSQL("INSERT INTO "+TABLE_NAME+" (PLACE_NAME,MAXIMUM_ALLOWED,CURRENT_FOOTFALL) VALUES ('Library',20,1)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       onCreate(db);
    }

    public void insertdata(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_NAME+" SET "+CURRENT_FOOTFALL+"="+(CURRENT_FOOTFALL+1));


    }

}
