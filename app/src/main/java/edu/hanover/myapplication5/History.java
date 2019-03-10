package edu.hanover.myapplication5;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static edu.hanover.myapplication5.DatabaseHelper.insertHistory;

public class History extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    //SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        //TextView history = (TextView) findViewById(R.id.textView2) ;
        ListView history = (ListView) findViewById(R.id.SavedHistory);

        String cardioExercise = getIntent().getStringExtra("cardioExercise");
        String liftExercise = getIntent().getStringExtra("liftExercise");
        String yogaExercise = getIntent().getStringExtra("yogaExercise");
        SQLiteDatabase db = openOrCreateDatabase("workouthistory",MODE_PRIVATE,null);
//        db.execSQL("CREATE TABLE HISTORY ("
//                + " CARDIO TEXT, "
//                + "LIFT TEXT, "
//                + "YOGA TEXT);");
        insertHistory(db, cardioExercise, liftExercise, yogaExercise);

        history = (ListView)findViewById(R.id.SavedHistory);
        //db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
        Cursor h = db.query("HISTORY", new String[] {"CARDIO", "LIFT", "YOGA"}, null, null, null, null, null);
        ArrayList ar = new ArrayList();
        //ArrayList ar = new ArrayList();
        while (h.moveToNext()) {
            if (!(ar.contains(h.getString(0)))){
                ar.add(h.getString(0));
                ar.add(h.getString(1));
                ar.add(h.getString(2));

            }
            ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ar);
            history.setAdapter(ad);

//
//        Cursor h = db.query("HISTORY", new String[] {"CARDIO", "LIFT", "YOGA"}, null, null, null, null, null);
//        if (h.moveToFirst()){
//            String cardioText = h.getString(0);
//            String liftText = h.getString(1);
//            String yogaText = h.getString(2);
//            history.setText(cardioText);
//            history.append(liftText);
//            history.append(yogaText);
//
//        }
//        h.close();
//        db.close();

}}}
