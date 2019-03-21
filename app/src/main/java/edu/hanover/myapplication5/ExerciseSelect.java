package edu.hanover.myapplication5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ExerciseSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_select);

        final Spinner cardio = (Spinner) findViewById(R.id.spinner_cardio); //creates cardio dropdown

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cardio.setAdapter(adapter);
        adapter.addAll("Running", "Biking", "Elliptical"); //add cardio exercises into dropdown

        final Spinner intensity = (Spinner) findViewById(R.id.spinner_intensity); //creates intensity dropdown

        ArrayAdapter adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        intensity.setAdapter(adapter1);
        adapter1.addAll("Beginner", "Intermediate", "Advanced"); //add intensity options into dropdown


        final Spinner muscle = (Spinner) findViewById(R.id.spinner_muscle); //creates muscle group dropdown

        ArrayAdapter adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        muscle.setAdapter(adapter2);
        adapter2.addAll("Upper Body", "Mid Body", "Lower Body"); //adds muscle groups into dropdown

        //get selected cardio exercise from spinner
        cardio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                //had to add exercise to textview in order to retrieve later
                String cardioexercise = cardio.getItemAtPosition(i).toString();
                TextView textViewC = (TextView)findViewById(R.id.textView7);
                textViewC.setText(cardioexercise);
            }

            public void onNothingSelected(
                    AdapterView<?> adapterView) {}
        });
        //get selected intensity from spinner
        intensity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                String intensityexercise = intensity.getItemAtPosition(i).toString(); //had to add to textview in order to retrieve later
                TextView textViewI = (TextView)findViewById(R.id.textView8);
                textViewI.setText(intensityexercise);
            }

            public void onNothingSelected(
                    AdapterView<?> adapterView) {}
        });
        //get selected muscle group from spinner
        muscle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                String muscleexercise = muscle.getItemAtPosition(i).toString(); //had to add to textview in order to retrieve later
                TextView textViewM = (TextView)findViewById(R.id.textView9);
                textViewM.setText(muscleexercise);
            }

            public void onNothingSelected(
                    AdapterView<?> adapterView) {}
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
