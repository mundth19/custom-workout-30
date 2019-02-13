package edu.hanover.myapplication5;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;

public class ExerciseSelect extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_select);

        Spinner cardio = (Spinner) findViewById(R.id.spinner_cardio);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cardio.setAdapter(adapter);

        db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
        Cursor c = db.rawQuery("select name from cardio", null);
        //ArrayList ar = new ArrayList();
        while (c.moveToNext()) {
            //if (!(ar.contains(c.getString(0)))){
                adapter.add(c.getString(0));
           // }
        }
        adapter.remove("Running");adapter.remove("Running");adapter.remove("Biking");adapter.remove("Biking");adapter.remove("Elliptical");adapter.remove("Elliptical");

        Spinner intensity = (Spinner) findViewById(R.id.spinner_intensity);

        ArrayAdapter adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        intensity.setAdapter(adapter1);

        db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
        Cursor c1 = db.rawQuery("select intensity from cardio", null);
        //ArrayList ar1 = new ArrayList();
        while (c1.moveToNext()) {
            //if (!(ar1.contains(c1.getString(0)))){
                adapter1.add(c1.getString(0));
            //}
        }
        adapter1.remove("Beginner");adapter1.remove("Beginner");adapter1.remove("Intermediate");adapter1.remove("Intermediate");adapter1.remove("Advanced");adapter1.remove("Advanced");


        Spinner muscle = (Spinner) findViewById(R.id.spinner_muscle);

        ArrayAdapter adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        muscle.setAdapter(adapter2);

        db = openOrCreateDatabase("workouts",MODE_PRIVATE,null);
        Cursor c2 = db.rawQuery("select name from lifting", null);
        //ArrayList ar2 = new ArrayList();
        while (c2.moveToNext()) {
            //if (!(ar2.contains(c2.getString(0)))){
                adapter2.add(c2.getString(0));
            }
        adapter2.remove("Upper Body");adapter2.remove("Upper Body");adapter2.remove("Upper Body");adapter2.remove("Upper Body");adapter2.remove("Upper Body");adapter2.remove("Upper Body");adapter2.remove("Upper Body");adapter2.remove("Upper Body");
        adapter2.remove("Mid Body");adapter2.remove("Mid Body");adapter2.remove("Mid Body");adapter2.remove("Mid Body");adapter2.remove("Mid Body");adapter2.remove("Mid Body");adapter2.remove("Mid Body");adapter2.remove("Mid Body");
        adapter2.remove("Lower Body");adapter2.remove("Lower Body");adapter2.remove("Lower Body");adapter2.remove("Lower Body");adapter2.remove("Lower Body");adapter2.remove("Lower Body");adapter2.remove("Lower Body");adapter2.remove("Lower Body");
        

        }


    }
