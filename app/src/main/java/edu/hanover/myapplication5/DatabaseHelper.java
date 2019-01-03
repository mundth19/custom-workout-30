package edu.hanover.myapplication5;

import android.app.Activity;
import android.os.Bundle;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "workouts"; // the name of our database
    private static final int DB_VERSION = 1; //version of database
    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CARDIO ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + " NAME TEXT, "
                + "INTENSITY TEXT, "
                + "DESCRIPTION TEXT);");
        insertCardio(db, "Running", "Beginner", "Run at a 15 minute mile pace for 10 minutes", 1);
        insertCardio(db, "Running", "Intermediate", "Run at a 11 minute mile pace for 10 minutes", 2);
        insertCardio(db, "Running", "Advanced", "Run at a 7.5 minute mile pace for 10 minutes", 3);
        insertCardio(db, "Biking", "Beginner", "Bike at a 10 mph speed for 10 minutes", 4);
        insertCardio(db, "Biking", "Intermediate", "Bike at a 13 mph speed for 10 minutes", 5);
        insertCardio(db, "Biking", "Advanced", "Bike at a 15 mph speed for 10 minutes", 6);
        insertCardio(db, "Elliptical","Beginner", "Exercise on an elliptical at speed 5 for 10 minutes", 7);
        insertCardio(db, "Elliptical", "Intermediate", "Exercise on an elliptical at speed 7 for 10 minutes", 8);
        insertCardio(db, "Elliptical", "Advanced", "Exercise on an elliptical at speed 9 for 10 minutes", 9);

        db.execSQL("CREATE TABLE LIFTING ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + " NAME TEXT, "
                + "INTENSITY TEXT, "
                + "DESCRIPTION TEXT);");
        insertLifting(db, "Upper Body", "Beginner", "8 bicep curls per arm; 3 sets", 1);
        //insert rest of lifting exercises here

        db.execSQL("CREATE TABLE YOGA ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + " NAME TEXT, "
                + "INTENSITY TEXT, "
                + "DESCRIPTION TEXT);");
        //insert yoga exercises here

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { {   } }

    private static void insertCardio (SQLiteDatabase db, String name, String intensity, String description, int resourceId ){
        ContentValues cardioValues = new ContentValues();
        cardioValues.put("_id", resourceId);
        cardioValues.put("NAME", name);
        cardioValues.put("INTENSITY", intensity);
        cardioValues.put("DESCRIPTION", description);
        db.insert("CARDIO", null, cardioValues);
    }
    private static void insertLifting (SQLiteDatabase db, String name, String intensity, String description, int resourceId ){
        ContentValues liftingValues = new ContentValues();
        liftingValues.put("_id", resourceId);
        liftingValues.put("NAME", name);
        liftingValues.put("INTENSITY", intensity);
        liftingValues.put("DESCRIPTION", description);
        db.insert("LIFTING", null, liftingValues);
    }

    private static void insertYoga (SQLiteDatabase db, String name, String intensity, String description, int resourceId ) {
        ContentValues yogaValues = new ContentValues();
        yogaValues.put("_id", resourceId);
        yogaValues.put("NAME", name);
        yogaValues.put("INTENSITY", intensity);
        yogaValues.put("DESCRIPTION", description);
        db.insert("YOGA", null, yogaValues);
    }


}

