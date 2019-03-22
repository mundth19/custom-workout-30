package edu.hanover.myapplication5;

//this class creates the database consisting of 4 tables; 3 of which contain workouts where the user will select from,
// and 1 that contains history

import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatabaseHelper extends SQLiteOpenHelper {
    String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    private static final String DB_NAME = "workouts"; // the name of database
    private static final int DB_VERSION = 1; //version of database
    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db = this.getWritableDatabase();

        //creating CARDIO table
        db.execSQL("CREATE TABLE CARDIO ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + " NAME TEXT, "
                + "INTENSITY TEXT, "
                + "DESCRIPTION TEXT);");
        //cardio exercises inserted into cardio table below
        insertCardio(db, "Running", "Beginner", "Run at a 15 minute mile pace for 10 minutes", 1);
        insertCardio(db, "Running", "Intermediate", "Run at a 11 minute mile pace for 10 minutes", 2);
        insertCardio(db, "Running", "Advanced", "Run at a 7.5 minute mile pace for 10 minutes", 3);
        insertCardio(db, "Biking", "Beginner", "Bike at a 10 mph speed for 10 minutes", 4);
        insertCardio(db, "Biking", "Intermediate", "Bike at a 13 mph speed for 10 minutes", 5);
        insertCardio(db, "Biking", "Advanced", "Bike at a 15 mph speed for 10 minutes", 6);
        insertCardio(db, "Elliptical","Beginner", "Exercise on an elliptical at speed 5 for 10 minutes", 7);
        insertCardio(db, "Elliptical", "Intermediate", "Exercise on an elliptical at speed 7 for 10 minutes", 8);
        insertCardio(db, "Elliptical", "Advanced", "Exercise on an elliptical at speed 9 for 10 minutes", 9);

        //creating LIFTING table
        db.execSQL("CREATE TABLE LIFTING ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + " NAME TEXT, "
                + "INTENSITY TEXT, "
                + "DESCRIPTION TEXT);");
        //upper body exercises inserted into LIFTING table
        insertLifting(db, "Upper Body", "Beginner", "8 bicep curls per arm; 3 sets", 1);
        insertLifting(db, "Upper Body", "Intermediate", "8 bicep curls per arm; 4 sets", 2);
        insertLifting(db, "Upper Body", "Advanced", "10 bicep curls per arm; 3 sets", 3);
        insertLifting(db, "Upper Body", "Beginner", "5 tricep dips; 3 sets", 4);
        insertLifting(db, "Upper Body", "Intermediate", "5 tricep dips; 4 sets", 5);
        insertLifting(db, "Upper Body", "Advanced", "8 tricep dips; 3 sets", 6);
        insertLifting(db, "Upper Body", "Beginner", "4 push-ups; 3 sets", 7);
        insertLifting(db, "Upper Body", "Intermediate", "5 push-ups; 4 sets", 8);
        insertLifting(db, "Upper Body", "Advanced", "7 push-ups; 4 sets", 9);
        insertLifting(db, "Upper Body", "Beginner", "3 pull-ups; 3 sets", 10);
        insertLifting(db, "Upper Body", "Intermediate", "4 pull-ups; 4 sets", 11);
        insertLifting(db, "Upper Body", "Advanced", "6 pull-ups; 3 sets", 12);
        insertLifting(db, "Upper Body", "Beginner", "4 dumbbell presses; 3 sets/arm", 13);
        insertLifting(db, "Upper Body", "Intermediate", "4 dumbbell presses; 4 sets/arm", 14);
        insertLifting(db, "Upper Body", "Advanced", "6 dumbbell presses; 3 sets/arm", 15);

        //mid body exercises inserted into LIFTING table
        insertLifting(db, "Mid Body", "Beginner", "15 crunches; 3 sets", 16);
        insertLifting(db, "Mid Body", "Intermediate", "25 crunches; 3 sets", 17);
        insertLifting(db, "Mid Body", "Advanced", "35 crunches; 3 sets", 18);
        insertLifting(db, "Mid Body", "Beginner", "15 russian twists; 3 sets", 19);
        insertLifting(db, "Mid Body", "Intermediate", "25 russian twists; 3 sets", 20);
        insertLifting(db, "Mid Body", "Advanced", "35 russian twists; 3 sets", 21);
        insertLifting(db, "Mid Body", "Beginner", "plank for 20 seconds; 3 sets", 22);
        insertLifting(db, "Mid Body", "Intermediate", "plank for 45 seconds; 3 sets", 23);
        insertLifting(db, "Mid Body", "Advanced", "plank for 1 minute; 3 sets", 24);
        insertLifting(db, "Mid Body", "Beginner", "20 sec side plank; 3 sets/side", 25);
        insertLifting(db, "Mid Body", "Intermediate", "40 sec side plank; 3 sets/side", 26);
        insertLifting(db, "Mid Body", "Advanced", "60 sec side plank; 3 sets/side", 27);
        insertLifting(db, "Mid Body", "Beginner", "20 mountain climbers; 3 sets", 28);
        insertLifting(db, "Mid Body", "Intermediate", "35 mountain climbers; 3 sets", 29);
        insertLifting(db, "Mid Body", "Advanced", "50 mountain climbers; 3 sets", 30);

        //lower body exercises inserted into LIFTING table
        insertLifting(db, "Lower Body", "Beginner", "5 squats with dumbbells; 3 sets", 31);
        insertLifting(db, "Lower Body", "Intermediate", "8 squats with dumbbells; 3 sets", 32);
        insertLifting(db, "Lower Body", "Advanced", "12 squats with dumbbells; 3 sets", 33);
        insertLifting(db, "Lower Body", "Beginner", "4 lunges per leg with dumbbells; 3 sets", 34);
        insertLifting(db, "Lower Body", "Intermediate", "8 lunges per leg with dumbbells; 3 sets", 35);
        insertLifting(db, "Lower Body", "Advanced", "10 lunges per leg with dumbbells; 3 sets", 36);
        insertLifting(db, "Lower Body", "Beginner", "10 weighted calf raises; 3 sets", 37);
        insertLifting(db, "Lower Body", "Intermediate", "15 weighted calf raises; 3 sets", 38);
        insertLifting(db, "Lower Body", "Advanced", "20 weighted calf raises; 3 sets", 39);
        insertLifting(db, "Lower Body", "Beginner", "5 single leg deadlifts; 3 sets/leg", 40);
        insertLifting(db, "Lower Body", "Intermediate", "8 single leg deadlifts; 3 sets/leg", 41);
        insertLifting(db, "Lower Body", "Advanced", "8 single leg deadlifts; 4 sets/leg", 42);
        insertLifting(db, "Lower Body", "Beginner", "5 glute kickbacks; 3 sets/leg", 43);
        insertLifting(db, "Lower Body", "Intermediate", "8 glute kickbacks; 3 sets/leg", 44);
        insertLifting(db, "Lower Body", "Advanced", "8 glute kickbacks; 4 sets/leg", 45);

        //creating YOGA table
        db.execSQL("CREATE TABLE YOGA ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + " NAME TEXT, "
                + "INTENSITY TEXT, "
                + "DESCRIPTION TEXT);");
        //yoga exercises inserted into YOGA table
        insertYoga(db, "Upper Body","Overhead triceps and shoulder stretch; hold for 10 seconds; 3 sets/arm", 1);
        insertYoga(db, "Upper Body",  "Cross-body shoulder stretch; hold for 10 seconds; 3 sets/arm", 2);
        insertYoga(db, "Mid Body", "Cat Cow pose; hold for 30 seconds; 3 sets",  3);
        insertYoga(db, "Mid Body", "Cobra stretch; hold for 30 seconds; 3 sets ", 4);
        insertYoga(db, "Lower Body", "Flamingo stretch; hold for 10 seconds; 3 sets/leg", 5);
        insertYoga(db, "Lower Body", "Standing wall stretch; hold for 10 seconds; 3 sets/leg", 6);

//        db.execSQL("CREATE TABLE SAVED ("
//                + "DATE TEXT, "
//                + " CARDIO TEXT, "
//                + "LIFT TEXT, "
//                + "YOGA TEXT, "
//                + "NOTES TEXT);");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { {} }

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

    private static void insertYoga (SQLiteDatabase db, String name, String description, int resourceId ) {
        ContentValues yogaValues = new ContentValues();
        yogaValues.put("_id", resourceId);
        yogaValues.put("NAME", name);
        yogaValues.put("DESCRIPTION", description);
        db.insert("YOGA", null, yogaValues);
    }

    public static void insertHistory(SQLiteDatabase db, String date, String cardio, String lift, String yoga, String notes) {
        ContentValues historyValues = new ContentValues();
        historyValues.put("DATE", date);
        historyValues.put("CARDIO", cardio);
        historyValues.put("LIFT", lift);
        historyValues.put("YOGA", yoga);
        historyValues.put("NOTES", notes);
        db.insert("SAVED", null, historyValues);
    }

}

