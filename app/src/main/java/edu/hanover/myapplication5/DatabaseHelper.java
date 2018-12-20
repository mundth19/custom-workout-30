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

        ContentValues cardioValues = new ContentValues();
        cardioValues.put("NAME", "Running");
        cardioValues.put("INTENSITY", "Beginner");
        cardioValues.put("DESCRIPTION", "Run at a 12 minute mile pace for 10 minutes.");
        db.insert("CARDIO", null, cardioValues);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {    } }


//public class DataActivity extends Activity {

//@Override
//protected void onCreate(Bundle savedInstanceState) {
//super.onCreate(savedInstanceState);
//setContentView(R.layout.activity_data);
//}
//}
