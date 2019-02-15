package edu.hanover.myapplication5;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ExerciseSelect extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_select);

        final Spinner cardio = (Spinner) findViewById(R.id.spinner_cardio);

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


        final Spinner intensity = (Spinner) findViewById(R.id.spinner_intensity);

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


        final Spinner muscle = (Spinner) findViewById(R.id.spinner_muscle);

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

//        cardio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Object item = parent.getItemAtPosition(position);
//            }
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
        cardio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                String cardioexercise = cardio.getItemAtPosition(i).toString();
                TextView textViewC = (TextView)findViewById(R.id.textView7);
                textViewC.setText(cardioexercise);
            }

            public void onNothingSelected(
                    AdapterView<?> adapterView) {

            }
        });

        intensity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                String intensityexercise = intensity.getItemAtPosition(i).toString();
                TextView textViewI = (TextView)findViewById(R.id.textView8);
                textViewI.setText(intensityexercise);
            }

            public void onNothingSelected(
                    AdapterView<?> adapterView) {

            }
        });

        muscle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                String muscleexercise = muscle.getItemAtPosition(i).toString();
                TextView textViewM = (TextView)findViewById(R.id.textView9);
                textViewM.setText(muscleexercise);
            }

            public void onNothingSelected(
                    AdapterView<?> adapterView) {

            }
        });

        findViewById(R.id.button12).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textViewCardio = (TextView)findViewById(R.id.textView7);
                TextView textViewIntensity = (TextView)findViewById(R.id.textView8);
                TextView textViewMuscle = (TextView)findViewById(R.id.textView9);
                Intent intent = new Intent(ExerciseSelect.this, Workout.class);
                intent.putExtra("cardiotext", textViewCardio.getText().toString());
                intent.putExtra("intensitytext", textViewIntensity.getText().toString());
                intent.putExtra("muscletext", textViewMuscle.getText().toString());
                startActivity(intent);
            }
        });


    }



    }
